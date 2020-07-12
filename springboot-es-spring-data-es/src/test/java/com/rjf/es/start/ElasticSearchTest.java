package com.rjf.es.start;

import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.aggregations.Aggregation;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.metrics.valuecount.InternalValueCount;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.aggregation.AggregatedPage;
import org.springframework.data.elasticsearch.core.query.FetchSourceFilter;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

/*
 *
 *   Rene
 *   2020/7/6 23:26
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = EsApp.class)
public class ElasticSearchTest {

    @Autowired
    ElasticsearchRestTemplate elasticsearchRestTemplate;

    @Autowired
    UserRepository userRepository;

    private Pageable pageable = PageRequest.of(0, 10);

    // 索引操作
    @Test
    public void addIndexTest() {
        elasticsearchRestTemplate.createIndex(User.class);
        elasticsearchRestTemplate.putMapping(User.class);
    }

    @Test
    public void deleteIndex() {
        boolean index001 = elasticsearchRestTemplate.deleteIndex("index001");
    }


    // 文档操作

    // 插入测试数据
    @Test
    public void createDocument() {
        List<User> list = new ArrayList<>();
        list.add(new User(1, "xiaoming", "c001", "打球 电影 java开发 前端开发", "1996-11-23"));
        list.add(new User(2, "xiaohong", "c001", "羽毛球 蜘蛛侠 python开发 vue", "1997-11-23"));
        list.add(new User(3, "xiaohua", "c002", "游泳 电影 go开发 游戏", "1996-10-23"));
        list.add(new User(4, "xiaoli", "c002", "主机游戏 小说 天天酷跑 做饭", "1996-10-23"));
        list.add(new User(5, "xiaoliu", "c003", "数码 电子技术 可乐 鸡肉", "1996-11-20"));
        // 接收对象集合，实现批量新增
        userRepository.saveAll(list);
    }

    // 删除数据
    @Test
    public void deleteDocument() {
        userRepository.deleteAll();
    }

    // 查询全部
    @Test
    public void findAll() {

        Iterable<User> all = userRepository.findAll();
        all.forEach(System.out::println);
    }

    // 查询全部 并按生日排序
    @Test
    public void findAllAndSortByBirthday() {
        userRepository.findAll(Sort.by(Sort.Direction.DESC, "birthday"))
                .forEach(System.out::println);
    }

    // id查询
    @Test
    public void searchById() {
        List<User> user = userRepository.findById("1");
        user.forEach(System.out::println);
    }

    // 自定义查询 姓名查询
    @Test
    public void searchByName01() {
        List<User> user = userRepository.findByName("xiaoming");
        user.forEach(System.out::println);
    }

    // 姓名查询(高级构建器)
    @Test
    public void searchByName02() {
        // 通过查询构建器构建查询条件
        MatchQueryBuilder matchQueryBuilder = QueryBuilders.matchQuery("name", "xiaoming");
        //执行查询
        Iterable<User> Users = userRepository.search(matchQueryBuilder);
        Users.forEach(System.out::println);
    }

    // 自定义查询 根据生日范围
    @Test
    public void findAllBetweenBirthday() {
        userRepository.findByBirthdayBetween("1996-11-20", "1997-01-01")
                .forEach(System.out::println);
    }

    // 爱好查询
    @Test
    public void findByHobby() {
        Iterable<User> Users = userRepository.findByHobby("电影");
        Users.forEach(System.out::println);
    }


    // 自定义高级查询
    @Test
    public void findAdvance() {

        // 1. 自定义查询构建器
        NativeSearchQueryBuilder nativeSearchQueryBuilder = new NativeSearchQueryBuilder();

        // 2. 各种条件
        // 分词条件
        nativeSearchQueryBuilder.withQuery(QueryBuilders.matchQuery("hobby", "开发"));
        // 排序条件
        nativeSearchQueryBuilder.withSort(SortBuilders.fieldSort("birthday").order(SortOrder.DESC));
        // 分页条件
        nativeSearchQueryBuilder.withPageable(PageRequest.of(0, 10));


        // 3. 执行查询获取结果集

        Page<User> Users = userRepository.search(nativeSearchQueryBuilder.build());
        System.out.println("总条数 ---> " + Users.getTotalElements());
        System.out.println("总页数 ---> " + Users.getTotalPages());
        Users.forEach(System.out::println);

    }


    // 简单聚合
    @Test
    public void testCountId() {
        // 构造查询条件
        NativeSearchQueryBuilder queryBuilder = new NativeSearchQueryBuilder();
        // 不查询任何结果
        queryBuilder.withSourceFilter(new FetchSourceFilter(new String[]{""}, null));

        // 统计总数
        queryBuilder.addAggregation(AggregationBuilders.count("id"));

        AggregatedPage<User> people = (AggregatedPage<User>) userRepository.search(queryBuilder.build());
        long idCount = ((InternalValueCount) people.getAggregation("id")).getValue();
        System.out.println("统计总数 ---> " + idCount);
    }

    // 聚合
    @Test
    public void testAgg() {
        // 构建查询器
        NativeSearchQueryBuilder queryBuilder = new NativeSearchQueryBuilder();
        // 结果集 过滤不包括任何字段
        queryBuilder.withSourceFilter(new FetchSourceFilter(new String[]{}, null));
        // 聚合
        queryBuilder.addAggregation(AggregationBuilders.terms("name").field("name"));

        /*
        解析聚合结果集,根据聚合的类型以及字段类型,要进行强转,不然无法获取桶
        birthday-是字符串类型的,聚合类型是词条类型的
        aggBir-通过聚合名称获取聚合对象
        使用StringTerms强转的时候出现错误
         */

        // 执行查询
        AggregatedPage<User> userAggregatedPage = (AggregatedPage<User>) userRepository.search(queryBuilder.build());
        // 结果集处理
        Aggregation name = userAggregatedPage.getAggregation("name");
        System.out.println("计数id ---> " + name);
    }

}

