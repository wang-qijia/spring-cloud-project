package com.sunhome.cloud.alarm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;


@EnableAsync
@SpringBootApplication
public class AlarmServerBootstrap {

    public static void main(String[] args) {
        SpringApplication.run(AlarmServerBootstrap.class, args);
    }
}
