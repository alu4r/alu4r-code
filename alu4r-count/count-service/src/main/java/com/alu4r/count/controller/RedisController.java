package com.alu4r.count.controller;

import com.alu4r.count.utils.RedisUtil;
import com.baomidou.mybatisplus.extension.api.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: redise测试
 * @author: alu4r
 * @date: 2020/11/28 16:58
 */
@RestController
@RequestMapping("redis")
public class RedisController {

    @Autowired
    RedisUtil redisUtil;

    @RequestMapping("set")
    public R getKey(String key, String value){
        return R.ok(redisUtil.set(key, value));
    }
}
