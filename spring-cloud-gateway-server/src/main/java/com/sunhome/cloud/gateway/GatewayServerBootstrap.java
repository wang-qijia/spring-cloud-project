package com.sunhome.cloud.gateway;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@EnableDiscoveryClient
@SpringBootApplication
public class GatewayServerBootstrap {

    public static void main(String[] args) {
        SpringApplication.run(GatewayServerBootstrap.class, args);
    }




}
