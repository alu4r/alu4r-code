package com.example.fanout;

import com.example.utils.RabbitMqUtils;
import com.rabbitmq.client.*;

import java.io.IOException;

/**
 * @description:
 * @author: alu4r
 * @date: 2020/10/26 23:17
 */
public class Customer2 {
    /**
     * 交换机名称
     */
    public static final String EXCHANGE = "logs";

    public static void main(String[] args) throws IOException {
        Connection connection = RabbitMqUtils.getConnection();
        Channel channel = connection.createChannel();
        //通道绑定交换机
        channel.exchangeDeclare(EXCHANGE,"fanout");
        //临时队列
        String queueName = channel.queueDeclare().getQueue();
        //绑定交换机和队列
        channel.queueBind(queueName, EXCHANGE, "");
        //消费消息
        channel.basicConsume(queueName, true, new DefaultConsumer(channel){
            /**
             * No-op implementation of {@link Consumer#handleDelivery}.
             *
             * @param consumerTag
             * @param envelope
             * @param properties
             * @param body
             */
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("消费者2：" + new String(body));
            }
        });

    }

}
