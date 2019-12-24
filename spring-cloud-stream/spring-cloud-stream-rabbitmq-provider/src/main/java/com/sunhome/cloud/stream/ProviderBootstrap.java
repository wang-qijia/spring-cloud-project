package com.sunhome.cloud.stream;

import com.sunhome.cloud.stream.config.MqProviderSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;


@EnableBinding(MqProviderSource.class)
@SpringBootApplication
public class ProviderBootstrap {

    public static void main(String[] args) {
        SpringApplication.run(ProviderBootstrap.class, args);
    }


}
