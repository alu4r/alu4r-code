package com.example.utils;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @description: RabbitMQ工具类
 * @author: alu4r
 * @date: 2020/10/26 22:38
 */
public class RabbitMqUtils {

    public static ConnectionFactory connectionFactory;

    static {
        connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("47.100.58.237");
        connectionFactory.setPort(5672);
        connectionFactory.setUsername("alu4r");
        connectionFactory.setPassword("rabbitmq//4142");
        connectionFactory.setVirtualHost("RabbitMQ_VH");
    }

    /**
     * 获取一个连接
     *
     * @return
     */
    public static Connection getConnection() {
        try {
            Connection connection = connectionFactory.newConnection();
            return connection;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 关闭连接和通道
     *
     * @param connection
     * @param channel
     */
    public static void closeConnectionAndChannel(Connection connection, Channel channel) {
        try {
            if (channel != null) {
                channel.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
