package com.sunhome.cloud.gateway.filter;

import org.springframework.beans.BeanUtils;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.GatewayFilterFactory;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class SpringGatewayFilterFactory implements
        GatewayFilterFactory<SpringGatewayFilterFactory.Config> {

    private final Class<Config> configClass = Config.class;

    @Override
    public List<String> shortcutFieldOrder() {
        return new ArrayList<>(Arrays.asList("key"));
    }

    @Override
    public GatewayFilter apply(Config config) {
        return ((exchange, chain) -> {
            ServerHttpRequest request = exchange.getRequest().mutate().headers(httpHeaders -> {

            }).build();
            return chain.filter(exchange.mutate().request(request).build());
        });
    }

    @Override
    public Class<Config> getConfigClass() {
        return configClass;
    }

    @Override
    public Config newConfig() {
        return BeanUtils.instantiateClass(this.configClass);
    }

    public static class Config {

        private String key;

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }
    }
}