package com.cloud.demo.config;



import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    /**
     * 可以看到上面写了两个回调函数，一个叫 ConfirmCallback ，一个叫 RetrunCallback；
     * 那么以上这两种回调函数都是在什么情况会触发呢？
     * 先从总体的情况分析，推送消息存在四种情况：
     * ①消息推送到server，但是在server里找不到交换机  : ConfirmCallback
     * ②消息推送到server，找到交换机了，但是没找到队列 :ConfirmCallback,ReturnCallback
     * ③消息推送到sever，交换机和队列啥都没找到 :ConfirmCallback
     * ④消息推送成功：{
     *     确认情况：true，
     *
     *接下来我们继续， 消费者接收到消息的消息确认机制。
     * 和生产者的消息确认机制不同，因为消息接收本来就是在监听消息，符合条件的消息就会消费下来。
     * 所以，消息接收的确认机制主要存在三种模式：
     * 1：自动确认， 这也是默认的消息确认情况。  AcknowledgeMode.NONE
     * RabbitMQ成功将消息发出（即将消息成功写入TCP Socket）中立即认为本次投递已经被正确处理，不管消费者端是否成功处理本次投递。
     * 所以这种情况如果消费端消费逻辑抛出异常，也就是消费端没有处理成功这条消息，那么就相当于丢失了消息。
     * 一般这种情况我们都是使用try catch捕捉异常后，打印日志用于追踪数据，这样找出对应数据再做后续处理。
     * 2：根据情况确认， 这个不做介绍
     * 3：手动确认 ， 这个比较关键，也是我们配置接收消息确认机制时，多数选择的模式。
     * 消费者收到消息后，手动调用basic.ack/basic.nack/basic.reject后，RabbitMQ收到这些消息后，才认为本次投递成功。
     * basic.ack用于肯定确认
     * basic.nack用于否定确认（注意：这是AMQP 0-9-1的RabbitMQ扩展）
     * basic.reject用于否定确认，但与basic.nack相比有一个限制:一次只能拒绝单条消息
     * 消费者端以上的3个方法都表示消息已经被正确投递，但是basic.ack表示消息已经被正确处理。
     * 而basic.nack,basic.reject表示没有被正确处理：
     * 着重讲下reject，因为有时候一些场景是需要重新入列的。
     * channel.basicReject(deliveryTag, true);
     * 拒绝消费当前消息，如果第二参数传入true，就是将数据重新丢回队列里，那么下次还会消费这消息。
     * 设置false，就是告诉服务器，我已经知道这条消息数据了，因为一些原因拒绝它，而且服务器也把这个消息丢掉就行。下次不想再消费这条消息了。
     * 使用拒绝后重新入列这个确认模式要谨慎，因为一般都是出现异常的时候，catch异常再拒绝入列，选择是否重入列。
     * 但是如果使用不当会导致一些每次都被你重入列的消息一直消费-入列-消费-入列这样循环，会导致消息积压。
     *
     *顺便也简单讲讲 nack，这个也是相当于设置不消费某条消息。
     * channel.basicNack(deliveryTag, false, true);
     * 第一个参数依然是当前消息到的数据的唯一id;
     * 第二个参数是指是否针对多条消息；如果是true，也就是说一次性针对当前通道的消息的tagID小于当前这条消息的，都拒绝确认。
     * 第三个参数是指是否重新入列，也就是指不确认的消息是否重新丢回到队列里面去。
     * 同样使用不确认后重新入列这个确认模式要谨慎，因为这里也可能因为考虑不周出现消息一直被重新丢回去的情况，导致积压。
     * }
     */
    @Bean
    RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        //设置开启Mandatory,才能触发回调函数,无论消息推送结果怎么样都强制调用回调函数
        rabbitTemplate.setMandatory(true);

        rabbitTemplate.setConfirmCallback(new RabbitTemplate.ConfirmCallback() {
            @Override
            public void confirm(CorrelationData correlationData, boolean ack, String cause) {
                System.out.println("ConfirmCallback:     "+"相关数据："+correlationData);
                System.out.println("ConfirmCallback:     "+"确认情况："+ack);
                System.out.println("ConfirmCallback:     "+"原因："+cause);
            }
        });

        rabbitTemplate.setReturnCallback(new RabbitTemplate.ReturnCallback() {
            @Override
            public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {
                System.out.println("ReturnCallback:     "+"消息："+message);
                System.out.println("ReturnCallback:     "+"回应码："+replyCode);
                System.out.println("ReturnCallback:     "+"回应信息："+replyText);
                System.out.println("ReturnCallback:     "+"交换机："+exchange);
                System.out.println("ReturnCallback:     "+"路由键："+routingKey);
            }
        });

        return rabbitTemplate;

    }


}
