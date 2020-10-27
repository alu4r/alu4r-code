package com.example.direct;

import com.example.utils.RabbitMqUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;

/**
 * @description:
 * @author: alu4r
 * @date: 2020/10/27 23:01
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
        channel.exchangeDeclare("log_direct", "direct");
        //发送消息
        String routingKey = "error";
        String message = "这是基于direct模式发送的消息，routingKey：" + routingKey;
        channel.basicPublish("log_direct", routingKey, null, message.getBytes());

        RabbitMqUtils.closeConnectionAndChannel(connection, channel);
    }
}
