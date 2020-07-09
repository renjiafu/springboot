package com.rjf;

import com.rjf.es.hlrc.EsApp;
import com.rjf.es.hlrc.service.RestHighLevelClientService;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/*
 *
 *   Rene
 *   2020/7/1 7:31
 */
@SpringBootTest(classes = EsApp.class)
@RunWith(SpringRunner.class)
public class HighClientTest {

    @Autowired
    RestHighLevelClientService clientService;

    @Test
    public void createIdx() throws Exception{
        String settings = "" +
                "  {\n" +
                "      \"number_of_shards\" : \"2\",\n" +
                "      \"number_of_replicas\" : \"0\"\n" +
                "   }";
        String mappings = "" +
                "{\n" +
                "    \"properties\": {\n" +
                "      \"itemId\" : {\n" +
                "        \"type\": \"keyword\",\n" +
                "        \"ignore_above\": 64\n" +
                "      },\n" +
                "      \"urlId\" : {\n" +
                "        \"type\": \"keyword\",\n" +
                "        \"ignore_above\": 64\n" +
                "      },\n" +
                "      \"sellAddress\" : {\n" +
                "        \"type\": \"text\",\n" +
                "        \"analyzer\": \"ik_max_word\", \n" +
                "        \"search_analyzer\": \"ik_smart\",\n" +
                "        \"fields\": {\n" +
                "          \"keyword\" : {\"ignore_above\" : 256, \"type\" : \"keyword\"}\n" +
                "        }\n" +
                "      },\n" +
                "      \"courierFee\" : {\n" +
                "        \"type\": \"text\n" +
                "      },\n" +
                "      \"promotions\" : {\n" +
                "        \"type\": \"text\",\n" +
                "        \"analyzer\": \"ik_max_word\", \n" +
                "        \"search_analyzer\": \"ik_smart\",\n" +
                "        \"fields\": {\n" +
                "          \"keyword\" : {\"ignore_above\" : 256, \"type\" : \"keyword\"}\n" +
                "        }\n" +
                "      },\n" +
                "      \"originalPrice\" : {\n" +
                "        \"type\": \"keyword\",\n" +
                "        \"ignore_above\": 64\n" +
                "      },\n" +
                "      \"startTime\" : {\n" +
                "        \"type\": \"date\",\n" +
                "        \"format\": \"yyyy-MM-dd HH:mm:ss\"\n" +
                "      },\n" +
                "      \"endTime\" : {\n" +
                "        \"type\": \"date\",\n" +
                "        \"format\": \"yyyy-MM-dd HH:mm:ss\"\n" +
                "      },\n" +
                "      \"title\" : {\n" +
                "        \"type\": \"text\",\n" +
                "        \"analyzer\": \"ik_max_word\", \n" +
                "        \"search_analyzer\": \"ik_smart\",\n" +
                "        \"fields\": {\n" +
                "          \"keyword\" : {\"ignore_above\" : 256, \"type\" : \"keyword\"}\n" +
                "        }\n" +
                "      },\n" +
                "      \"serviceGuarantee\" : {\n" +
                "        \"type\": \"text\",\n" +
                "        \"analyzer\": \"ik_max_word\", \n" +
                "        \"search_analyzer\": \"ik_smart\",\n" +
                "        \"fields\": {\n" +
                "          \"keyword\" : {\"ignore_above\" : 256, \"type\" : \"keyword\"}\n" +
                "        }\n" +
                "      },\n" +
                "      \"venue\" : {\n" +
                "        \"type\": \"text\",\n" +
                "        \"analyzer\": \"ik_max_word\", \n" +
                "        \"search_analyzer\": \"ik_smart\",\n" +
                "        \"fields\": {\n" +
                "          \"keyword\" : {\"ignore_above\" : 256, \"type\" : \"keyword\"}\n" +
                "        }\n" +
                "      },\n" +
                "      \"currentPrice\" : {\n" +
                "        \"type\": \"keyword\",\n" +
                "        \"ignore_above\": 64\n" +
                "      }\n" +
                "   }\n" +
                "}";
        clientService.createIndex("idx_item", settings, mappings);
    }



    @Test
    public void search() throws Exception{
        SearchResponse search = clientService.search("title", "酒", "currentPrice", "11", "149", "sellAddress", "武汉");
        SearchHits hits = search.getHits();
        SearchHit[] hits1 = hits.getHits();
        for (SearchHit doc:hits1    ) {
            System.out.println(doc.getSourceAsString());
        }
    }
}
