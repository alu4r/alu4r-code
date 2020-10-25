package com.alu4r.mq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * @description: 生产者
 * @author: alu4r
 * @date: 2020/10/24 23:38
 */
public class Send {

    private final static String QUEUE_NAME = "hello";

    public static void main(String[] argv) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("47.100.58.237");
        factory.setPort(5672);
        factory.setVirtualHost("RabbitMQ_VH");
        factory.setUsername("alu4r");
        factory.setPassword("rabbitmq//4142");
        //获取连接和通道
        try {
            Connection connection = factory.newConnection();
            Channel channel = connection.createChannel();
            /**
             * 1.队列名称
             * 2.定义是否持久化队列,MQ重启后还存在
             * 3.是否独占队列，只有这个连接能用
             * 4.是否完成后删除队列
             * 5.格外参数
             */
            channel.queueDeclare(QUEUE_NAME, true, false, false, null);

            while (true){
                Scanner scanner = new Scanner(System.in);
                String message = scanner.nextLine();

                /**
                 * 1.交换机
                 * 2.队列名称
                 * 3.额外设置    MessageProperties.PERSISTENT_TEXT_PLAIN:消息持久化
                 * 4.消息的具体内容
                 */
                channel.basicPublish("", QUEUE_NAME, MessageProperties.PERSISTENT_TEXT_PLAIN, message.getBytes(StandardCharsets.UTF_8));
                System.out.println(" [x] Sent '" + message + "'");
            }
        } catch (Exception e){
            e.printStackTrace();
        }

    }
}
