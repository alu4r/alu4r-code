package com.example.direct;

import com.example.utils.RabbitMqUtils;
import com.rabbitmq.client.*;

import java.io.IOException;

/**
 * @description:
 * @author: alu4r
 * @date: 2020/10/27 23:07
 */
public class Customer1 {
    public static void main(String[] args) throws IOException {
        Connection connection = RabbitMqUtils.getConnection();
        Channel channel = connection.createChannel();
        /**
         * 通过通道声明交换机
         * 1. 交换机名称
         * 2. direct路由模式
         */
        channel.exchangeDeclare("log_direct", "direct");
        //创建零食队列
        String queue = channel.queueDeclare().getQueue();

        //基于路由key绑定队列和交换机
        channel.queueBind(queue, "log_direct", "error");
        //获取消息
        channel.basicConsume(queue, true, new DefaultConsumer(channel){
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
                System.out.println("消费者error路由key："+ new String(body));
            }
        });
    }
}
