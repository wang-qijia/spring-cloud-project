package com.sunhome.cloud.stream.config;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 * @author wangqijia
 * @date 2019/12/23 17:28
 */
public interface MqConsumerSource {//自定义通道
    String MY_IN_PUT = "myInPut";

    @Input(MY_IN_PUT)
    SubscribableChannel input();
}

