package com.sunhome.cloud.doctor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

/**
 * @author wangqijia
 * @date 2019/12/11 10:22
 */
@EnableTurbine
@EnableDiscoveryClient
@SpringBootApplication
public class TurbineBootstrap {

    public static void main(String[] args) {
        SpringApplication.run(TurbineBootstrap.class, args);
    }
}
