package com.sunhome.cloud.stream.config;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * @author wangqijia
 * @date 2019/12/23 17:28
 */
public interface MqProviderSource {//自定义通道
    String MY_OUT_PUT = "myOutPut";

    @Output(MY_OUT_PUT)
    MessageChannel testOutPut();
}

