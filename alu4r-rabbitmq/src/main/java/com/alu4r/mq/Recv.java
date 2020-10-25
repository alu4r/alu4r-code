package com.alu4r.mq;

import com.rabbitmq.client.*;

import java.io.IOException;

/**
 * @description:
 * @author: alu4r
 * @date: 2020/10/24 23:58
 */
public class Recv {
    private final static String QUEUE_NAME = "hello";

    public static void main(String[] argv) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("47.100.58.237");
        factory.setPort(5672);
        factory.setVirtualHost("RabbitMQ_VH");
        factory.setUsername("alu4r");
        factory.setPassword("rabbitmq//4142");

        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        //一次值消费一个消息
        channel.basicQos(1);
        channel.queueDeclare(QUEUE_NAME, true, false, false, null);
        System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

        /**
         * 1.消费那个队列的信息
         * 2.开始消息的自动确认机制.true 将会自动发送的消费端，弊端就是消费端正在处理这些消息但是突然宕机。就会消息丢失
         * 3.消费时的回调接口
         */
        channel.basicConsume(QUEUE_NAME, false, new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String message = new String(body, "UTF-8");
                System.out.println(" [x] Received '" + message + "'");
                //手动确认消息，false表示确认一个消息
                channel.basicAck(envelope.getDeliveryTag(), false);
            }
        });
    }
}
