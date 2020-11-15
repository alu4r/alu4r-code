package com.example.fanout;

import com.example.utils.RabbitMqUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;

/**
 * @description:
 * @author: alu4r
 * @date: 2020/10/26 22:27
 */
public class Provider {
    /**
     * 交换机名称
     */
    public static final String EXCHANGE = "logs";

    public static void main(String[] args) throws IOException {
        Connection connection = RabbitMqUtils.getConnection();
        Channel channel = connection.createChannel();
        /**
         * 将通道声明指定交换机
         * 1.交换机名称。mq中没有logs交换机的时候会自动创建
         * 2.fanout：广播类型
         */
        channel.exchangeDeclare(EXCHANGE,"fanout");
        //发送消息
        channel.basicPublish(EXCHANGE, "", null, "message".getBytes());
        //释放资源
        RabbitMqUtils.closeConnectionAndChannel(connection, channel);
    }
}
