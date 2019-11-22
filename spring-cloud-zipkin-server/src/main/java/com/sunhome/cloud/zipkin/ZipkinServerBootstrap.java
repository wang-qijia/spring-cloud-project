package com.sunhome.cloud.zipkin;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import zipkin2.server.internal.EnableZipkinServer;
import zipkin2.storage.mysql.v1.MySQLStorage;

import javax.sql.DataSource;

@SpringBootApplication
@EnableDiscoveryClient
@EnableZipkinServer
public class ZipkinServerBootstrap {

    public static void main(String[] args) {
        SpringApplication.run(ZipkinServerBootstrap.class, args);
    }

    @Bean
    public MySQLStorage mySQLStorage(DataSource dataSource) {
        return MySQLStorage.newBuilder().datasource(dataSource).executor(Runnable::run).build();
    }

}
