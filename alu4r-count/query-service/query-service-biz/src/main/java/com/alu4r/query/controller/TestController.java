package com.alu4r.query.controller;

import com.alu4r.core.exception.BizException;
import com.baomidou.mybatisplus.extension.api.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: 查询服务测试controller
 * @author: alu4r
 * @date: 2020/11/28 15:31
 */
@Slf4j
@RestController
@RequestMapping("test")
public class TestController {

    @GetMapping("testA")
    public R testA(){
        log.info("===========A请求成功============");
        return R.ok("A请求成功");
    }

    @GetMapping("testB")
    public R testB(){
        log.info("===========B请求成功============");
        return R.ok("B请求成功");
    }

    @RequestMapping("signal")
    public R signal(){
        return R.ok("ok");
    }

}
