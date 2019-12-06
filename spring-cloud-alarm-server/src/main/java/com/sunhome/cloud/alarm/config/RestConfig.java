package com.sunhome.cloud.alarm.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author wangqijia
 * @date 2019/12/6 16:37
 */
@Configuration
public class RestConfig {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
