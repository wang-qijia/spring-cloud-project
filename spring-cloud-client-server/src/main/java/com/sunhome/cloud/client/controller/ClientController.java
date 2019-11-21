package com.sunhome.cloud.client.controller;

import com.sunhome.cloud.client.config.ClientProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author wangqijia
 * @date 2019/11/20 15:42
 */
@RestController
public class ClientController {

    @Autowired
    private ClientProperties clientProperties;

    @GetMapping("pull")
    public ClientProperties pull() {
        System.out.println("test 重试 begin");
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("test 重试 after");

        if (true) {
            throw new RuntimeException();
        }
        return clientProperties;
    }

}
