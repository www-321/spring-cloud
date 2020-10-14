package com.cloud.eurekaclientconsumer7001.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.ChannelAwareMessageListener;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.util.Map;

@Configuration
public class MyAckReceiver  implements ChannelAwareMessageListener {
    @Override
    public void onMessage(Message message, Channel channel) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        long deliveryTag = message.getMessageProperties().getDeliveryTag();
        try {

            String s = objectMapper.readValue(message.getBody(), String.class);


            //做一些业务处理
            if ("fanout.A".equals(message.getMessageProperties().getConsumerQueue())){
                System.out.println(s);
                System.out.println("消费的消息来自的队列名为："+message.getMessageProperties().getConsumerQueue());
                System.out.println("执行fanout.A中的消息的业务处理流程......");

            }

            /*
            deliveryTag（唯一标识 ID）：当一个消费者向 RabbitMQ 注册后，会建立起一个 Channel ，
            RabbitMQ 会用 basic.deliver 方法向消费者推送消息，这个方法携带了一个 delivery tag，
            它代表了 RabbitMQ 向该 Channel 投递的这条消息的唯一标识 ID，是一个单调递增的正整数，delivery tag 的范围仅限于 Channel
            multiple：为了减少网络流量，手动确认可以被批处理，当该参数为 true 时，则可以一次性确认 delivery_tag 小于等于传入值的所有消息
             */
            channel.basicAck(deliveryTag, true);

            Map<String, Object> headers = message.getMessageProperties().getHeaders();
            if (headers.containsKey("error")) {
                channel.basicNack(deliveryTag, false, false);
            }
        } catch (Exception e) {
            channel.basicReject(deliveryTag, false);
            e.printStackTrace();
        }


    }
}
