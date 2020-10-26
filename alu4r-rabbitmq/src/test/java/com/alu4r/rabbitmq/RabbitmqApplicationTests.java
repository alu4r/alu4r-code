package com.alu4r.rabbitmq;

import com.alu4r.rabbitmq.constants.RabbitConsts;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest(classes = RabbitmqApplication.class)
@RunWith(SpringRunner.class)
class RabbitmqApplicationTests {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Test
    void contextLoads() {
        Map<String, String> map = new HashMap<>();
        map.put("userName", "alu4r");
        map.put("passWord", "alu4r//4142");
        rabbitTemplate.convertAndSend(RabbitConsts.DIRECT_MODE_QUEUE_ONE, map);
    }

    @Test
    public void sendDirect() {
        Map<String, String> map = new HashMap<>();
        map.put("userName", "alu4r");
        map.put("passWord", "alu4r//4142");
        rabbitTemplate.convertAndSend(RabbitConsts.DIRECT_MODE_QUEUE_ONE, map);
    }
}
