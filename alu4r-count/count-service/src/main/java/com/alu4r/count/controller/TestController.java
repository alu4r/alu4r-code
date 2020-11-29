package com.alu4r.count.controller;

import com.alu4r.count.utils.RedisUtil;
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
@RequestMapping("test")
public class TestController {
    @RequestMapping("signal")
    public R signal(){
        return R.ok("成功发送信号！");
    }
}
