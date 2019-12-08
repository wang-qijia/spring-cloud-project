package com.sunhome.cloud.gateway;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;
import reactor.core.publisher.Mono;


@EnableDiscoveryClient
@SpringBootApplication
public class GatewayServerBootstrap {

    public static void main(String[] args) {
        SpringApplication.run(GatewayServerBootstrap.class, args);
    }


    @Bean
    public KeyResolver ipKeyResolver() {
        return exchange -> Mono.just(exchange.getRequest().getRemoteAddress().getHostName());
    }

}
