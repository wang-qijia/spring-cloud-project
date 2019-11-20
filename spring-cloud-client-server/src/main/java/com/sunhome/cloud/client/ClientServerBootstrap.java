package com.sunhome.cloud.client;

import com.sunhome.cloud.client.config.ClientProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableConfigurationProperties(ClientProperties.class)
@EnableDiscoveryClient
public class ClientServerBootstrap {

    public static void main(String[] args) {
        SpringApplication.run(ClientServerBootstrap.class, args);
    }

}
