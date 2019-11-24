package com.sunhome.cloud.auth.controller;

import com.ctrip.framework.apollo.Config;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfig;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {

    @ApolloConfig
    Config config;

    @GetMapping("getValue")
    public Object value() {
        return config.getProperty("name", "");
    }


}
