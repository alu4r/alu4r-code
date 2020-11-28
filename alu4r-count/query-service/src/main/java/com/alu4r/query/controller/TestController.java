package com.alu4r.query.controller;

import com.baomidou.mybatisplus.extension.api.R;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @description: 查询服务测试controller
 * @author: alu4r
 * @date: 2020/11/28 15:31
 */
@RestController
@RequestMapping("/query")
public class TestController {

    @GetMapping("/test")
    public R test(){
        return R.ok(new Date());
    }
}
