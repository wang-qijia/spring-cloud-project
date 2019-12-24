package com.sunhome.cloud.stream.controller;

import com.sunhome.cloud.stream.common.MqMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangqijia
 * @date 2019/12/24 13:56
 */
@RestController
public class MqSendController {

    @Qualifier("myOutPut")
    @Autowired
    private MessageChannel messageChannel;

    @GetMapping("send")
    public boolean send() {
        MqMessage mqMessage = new MqMessage();
        mqMessage.setName("test msg");
        mqMessage.setType(0);
        return messageChannel.send(MessageBuilder.withPayload(mqMessage).build());
    }
}
