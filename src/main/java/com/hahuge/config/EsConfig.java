package com.hahuge.config;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.InetAddress;
import java.net.UnknownHostException;


@Configuration
public class EsConfig {

    @Bean
    public TransportClient client() throws UnknownHostException {
        TransportAddress node1 = new TransportAddress(InetAddress.getByName("localhost"),9300);
//        InetSocketTransportAddress node2 = new InetSocketTransportAddress(
//                InetAddress.getByName("localhost"),9300
//        );
//        InetSocketTransportAddress node3 = new InetSocketTransportAddress(
//                InetAddress.getByName("localhost"),9300
//        );
        Settings settings = Settings.builder().put("cluster.name","wali").build();
        TransportClient client = new PreBuiltTransportClient(settings);
        client.addTransportAddress(node1);
//        client.addTransportAddress(node2);
//        client.addTransportAddress(node3);
        return client;
    }
}
