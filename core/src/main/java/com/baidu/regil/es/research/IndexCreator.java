/**
 * 
 */
package com.baidu.regil.es.research;

import org.elasticsearch.action.bulk.BulkRequestBuilder;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;

import com.baidu.regil.es.research.vo.User;

/**
 * @author david.wang
 *
 */
public class IndexCreator {

    public static void main(String[] args) {
        Settings settings = Settings.builder()
                .put("path.home", "/Users/odile/work/research-es/core")
                .put("cluster.name", "research_es")
                .put("node.name", "local")
                .build();
        TransportClient client = TransportClient.builder().settings(settings).build();
        client.addTransportAddress(new InetSocketTransportAddress("127.0.0.1", 9300));
        BulkRequestBuilder bulkRequest = client.prepareBulk();
        for (int i = 0; i < 1000000; ++i) {
            bulkRequest.add(client.prepareIndex("users", "user").setSource(User.randomUser().toString()));
        }
        BulkResponse response = bulkRequest.execute().actionGet();
        if (response.hasFailures()) {
            System.out.println("批量创建失败");
        } else {
            System.out.println(response);
        }
    }
}
