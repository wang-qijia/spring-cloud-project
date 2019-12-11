package com.sunhome.cloud.doctor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @author wangqijia
 * @date 2019/12/11 10:15
 */
@EnableHystrixDashboard
@EnableDiscoveryClient
@SpringBootApplication
public class HystrixDashboardBootstrap {
    public static void main(String[] args) {
        SpringApplication.run(HystrixDashboardBootstrap.class, args);
    }
}
