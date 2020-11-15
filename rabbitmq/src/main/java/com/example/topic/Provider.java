package com.example.topic;

import com.example.utils.RabbitMqUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;

/**
 * @description:
 * @author: alu4r
 * @date: 2020/10/28 21:05
 */
public class Provider {
    public static void main(String[] args) throws IOException {
        Connection connection = RabbitMqUtils.getConnection();
        Channel channel = connection.createChannel();
        /**
         * 通过通道声明交换机
         * 1. 交换机名称
         * 2. direct路由模式
         */
        channel.exchangeDeclare("topics", "topic");
        //发布消息
        String routingKey = "users.save";
        String message = "topice模式发送消息RoutingKey:" + routingKey;

        channel.basicPublish("topics", routingKey, null, message.getBytes());

        RabbitMqUtils.closeConnectionAndChannel(connection, channel);
    }
}
