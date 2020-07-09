package com.rjf.es.hlrc.config;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.AbstractFactoryBean;
import org.springframework.context.annotation.Configuration;

/*
 *
 *   Rene
 *   2020/7/1 7:20
 */
@Configuration
public class RestHighLevelClientConfig extends AbstractFactoryBean {

    @Value("9200")
    private String host;

    private RestHighLevelClient restHighLevelClient;

    @Override
    public void destroy() throws Exception {
        // 关闭Client
        if (restHighLevelClient != null) {
            restHighLevelClient.close();
        }
    }

    @Override
    public Class<RestHighLevelClient> getObjectType() {
        return RestHighLevelClient.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }

    @Override
    protected Object createInstance() throws Exception {
        try {
            // 如果有多个节点，构建多个HttpHost
            restHighLevelClient = new RestHighLevelClient(
                    RestClient.builder(
                            new HttpHost(host, 9200, "http")));
        } catch (Exception e) {
        }
        return restHighLevelClient;
    }
}
