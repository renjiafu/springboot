package com.rjf.es.start;

import com.rjf.es.start.dao.UserRepository;
import com.rjf.es.start.model.User;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.aggregations.Aggregation;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.bucket.terms.ParsedStringTerms;
import org.elasticsearch.search.aggregations.bucket.terms.StringTerms;
import org.elasticsearch.search.aggregations.bucket.terms.Terms;
import org.elasticsearch.search.aggregations.metrics.avg.ParsedAvg;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.aggregation.AggregatedPage;
import org.springframework.data.elasticsearch.core.query.FetchSourceFilter;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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

    @Test
    public void addIndexTest(){
        elasticsearchRestTemplate.createIndex(User.class);
        elasticsearchRestTemplate.putMapping(User.class);
    }

    @Test
    public void deleteIndex(){
        boolean index001 = elasticsearchRestTemplate.deleteIndex("index001");
    }

    /**
     * 新增和批量新增
     */
    @Test
    public void create() {

        /*新增*/
        User User = new User(1,"xiaoming","打球 电影 java开发 前端开发");
        userRepository.save(User);

        /*

                List<User> list = new ArrayList<>();
                list.add(new User(1,"xiaoming","打球 电影 java开发 前端开发"));
                list.add(new User(2,"xiaoming","打球 电影 java开发 前端开发"));
                // 接收对象集合，实现批量新增
                userRepository.saveAll(list);
        */
    }

    /**
     * 添加测试数据
     */
    @Test
    public void indexList() {
        List<User> list = new ArrayList<>();
        list.add(new User(1,"xiaoming","打球 电影 java开发 前端开发"));
        list.add(new User(2,"xiaohong","羽毛球 蜘蛛侠 python开发 vue"));
        list.add(new User(3,"xiaohua","游泳 电影 go开发 游戏"));
        list.add(new User(4,"xiaoli","主机游戏 小说 天天酷跑 做饭"));
        list.add(new User(5,"xiaoliu","数码 电子技术 可乐 鸡肉"));
        // 接收对象集合，实现批量新增
        userRepository.saveAll(list);
    }

    /**
     * 查询全部
     */
    @Test
    public void find() {

        System.out.println("users ---> " + userRepository.findById(1));
    }


    /**
     * 查询并排序
     */
    @Test
    public void findAllSort() {
        Iterable<User> Users = userRepository.findAll(Sort.by("name").descending());

        Users.forEach(System.out::println);
    }


    @Test
    public void findByHobby() {
        Iterable<User> Users = this.userRepository.findByHobby("电影","游戏");
        Users.forEach(System.out::println);
    }




    /**
     * 通过标题查询
     */
    @Test
    public void testSearch() {
        // 通过查询构建器构建查询条件
        MatchQueryBuilder matchQueryBuilder = QueryBuilders.matchQuery("title", "手机");
        //执行查询
        Iterable<User> Users = this.userRepository.search(matchQueryBuilder);
        Users.forEach(System.out::println);
    }

    @Test
    public void testNative() {
        //构建自定义查询构建器
        NativeSearchQueryBuilder nativeSearchQueryBuilder = new NativeSearchQueryBuilder();
        //添加基本的查询条件
        MatchQueryBuilder matchQueryBuilder = QueryBuilders.matchQuery("title", "手机");
        //执行查询获取分页结果集
        nativeSearchQueryBuilder.withQuery(matchQueryBuilder);

        Page<User> Users = this.userRepository.search(nativeSearchQueryBuilder.build());
        System.out.println("Users.getTotalElements() = " + Users.getTotalElements());
        System.out.println("Users.getTotalPages() = " + Users.getTotalPages());
        Users.forEach(System.out::println);

    }


    /**
     * 分页查询
     */

    @Test
    public void testNativeQuery() {
        // 构建查询条件
        NativeSearchQueryBuilder queryBuilder = new NativeSearchQueryBuilder();
        // 添加基本的分词查询
        queryBuilder.withQuery(QueryBuilders.termQuery("category", "手机"));

        // 初始化分页参数
        int page = 0;
        int size = 3;
        // 设置分页参数
        queryBuilder.withPageable(PageRequest.of(page, size));

        // 执行搜索，获取结果
        Page<User> Users = this.userRepository.search(queryBuilder.build());
        // 打印总条数
        System.out.println(Users.getTotalElements());
        // 打印总页数
        System.out.println(Users.getTotalPages());
        // 每页大小
        System.out.println(Users.getSize());
        // 当前页
        System.out.println(Users.getNumber());
        Users.forEach(System.out::println);
    }

    @Test
    public void testAggs() {

        //初始化自定义构建查询器
        NativeSearchQueryBuilder queryBuilder = new NativeSearchQueryBuilder();

        //添加聚合
        queryBuilder.addAggregation(AggregationBuilders.terms("brandAgg").field("brand"));

        //添加结果集过滤不包括任何字段
        queryBuilder.withSourceFilter(new FetchSourceFilter(new String[]{}, null));

        //执行查询
        AggregatedPage<User> UserPage = (AggregatedPage<User>)this.userRepository.search(queryBuilder.build());


        /*
        解析聚合结果集,根据聚合的类型以及字段类型,要进行强转,不然无法获取桶
         brand-是字符串类型的,聚合类型是词条类型的
        brandAgg-通过聚合名称获取聚合对象
        使用StringTerms强转的时候出现错误
         */

        ParsedStringTerms brandAgg =(ParsedStringTerms) UserPage.getAggregation("brandAgg");

        //获取桶
        List<? extends Terms.Bucket> buckets = brandAgg.getBuckets();

        //遍历输出
        buckets.forEach(bucket -> {
            System.out.println("bucket.getKeyAsString() = " + bucket.getKeyAsString());
            //获取条数
            System.out.println("bucket.getDocCount() = " + bucket.getDocCount());
        });

    }


    /**
     * 子聚合
     */
    @Test
    public void testSubAggs() {

        //初始化自定义构建查询器
        NativeSearchQueryBuilder queryBuilder = new NativeSearchQueryBuilder();

        //添加聚合
        queryBuilder.addAggregation(AggregationBuilders.terms("brandAgg").field("brand").subAggregation(AggregationBuilders.avg("price_avg").field("price")));

        //添加结果集过滤不包括任何字段
        queryBuilder.withSourceFilter(new FetchSourceFilter(new String[]{}, null));

        //执行查询
        AggregatedPage<User> UserPage = (AggregatedPage<User>)this.userRepository.search(queryBuilder.build());


        /*
        解析聚合结果集,根据聚合的类型以及字段类型,要进行强转,不然无法获取桶
         brand-是字符串类型的,聚合类型是词条类型的
        brandAgg-通过聚合名称获取聚合对象
        使用StringTerms强转的时候出现错误
         */

        StringTerms brandAgg =(StringTerms) UserPage.getAggregation("brandAgg");

        //获取桶
        List<StringTerms.Bucket> buckets = brandAgg.getBuckets();

        //遍历输出
        buckets.forEach(bucket -> {
            System.out.println("bucket.getKeyAsString() = " + bucket.getKeyAsString());
            //获取条数
            System.out.println("bucket.getDocCount() = " + bucket.getDocCount());

            //获取子聚合的map集合:key-聚合名称,value-对应的子聚合对象
            Map<String, Aggregation> stringAggregationMap = bucket.getAggregations().asMap();
            /*
            以前使用的InternalAvg强转出现转换异常
             */
            ParsedAvg price_avg =(ParsedAvg) stringAggregationMap.get("price_avg");


            System.out.println("price_avg.getValue() = " + price_avg.getValue());
        });

    }
}
