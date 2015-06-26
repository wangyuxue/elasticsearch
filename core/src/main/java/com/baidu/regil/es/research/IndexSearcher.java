/**
 * 
 */
package com.baidu.regil.es.research;

import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;

/**
 * @author david.wang
 * 
 */
public class IndexSearcher {

    /**
     * main method for search test
     * @param args
     */
    public static void main(String[] args) {
        Settings settings = Settings.builder()
                .put("path.home", "/Users/odile/work/research-es/core")
                .put("cluster.name", "research_es")
                .put("node.name", "local")
                .build();
        TransportClient client = TransportClient.builder().settings(settings).build();
        client.addTransportAddress(new InetSocketTransportAddress("127.0.0.1", 9300));
        QueryBuilder qb1 = QueryBuilders.matchQuery("name", "zhangsan");
        SearchResponse response = 
                client.prepareSearch("users")
                .setTypes("user")
                .setQuery(qb1)
                .execute()
                .actionGet();
        System.out.println(response);
        client.close();
    }
}
