package com.sunhome.cloud.stream;

import com.sunhome.cloud.stream.config.MqConsumerSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;


@EnableBinding(MqConsumerSource.class)
@SpringBootApplication
public class ConsumerBootstrap {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerBootstrap.class, args);
    }

}
