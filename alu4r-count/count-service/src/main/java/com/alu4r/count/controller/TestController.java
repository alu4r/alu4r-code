package com.alu4r.count.controller;

import com.baomidou.mybatisplus.extension.api.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: 用于测试得controller
 * @author: alu4r
 * @date: 2020/11/28 15:08
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    RedisTemplate redisTemplate;

    @RequestMapping("redis")
    public R redisTest(){
        redisTemplate.opsForValue().set("myKey","myValue");
        return R.ok(redisTemplate.opsForValue().get("myKey"));
    }
}
