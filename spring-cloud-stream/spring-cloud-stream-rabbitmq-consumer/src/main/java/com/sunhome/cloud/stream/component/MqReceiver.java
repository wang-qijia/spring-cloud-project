package com.sunhome.cloud.stream.component;

import com.rabbitmq.client.Channel;
import com.sunhome.cloud.stream.common.MqMessage;
import com.sunhome.cloud.stream.config.MqConsumerSource;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @author wangqijia
 * @date 2019/12/24 13:54
 */
@Component
public class MqReceiver {

    @StreamListener(MqConsumerSource.MY_IN_PUT)
    public void input(Message<MqMessage> message) {
        Channel channel = (com.rabbitmq.client.Channel) message.getHeaders().get(AmqpHeaders.CHANNEL);
        Long deliveryTag = (Long) message.getHeaders().get(AmqpHeaders.DELIVERY_TAG);
        try {
            channel.basicAck(deliveryTag, false);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(message.getPayload().getName() + ":" + message.getPayload().getType());
    }
}
