package com.sunhome.cloud.admin;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@EnableAdminServer
@SpringBootApplication
public class AdminServerBootstrap {

    public static void main(String[] args) {
        SpringApplication.run(AdminServerBootstrap.class, args);
    }

    @GetMapping("admin")
    public String test() {
        return "admin";
    }

}
