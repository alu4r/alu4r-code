package com.alu4r.query.controller;

import com.alu4r.core.exception.BizException;
import com.baomidou.mybatisplus.extension.api.R;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: 查询服务测试controller
 * @author: alu4r
 * @date: 2020/11/28 15:31
 */
@RestController
@RequestMapping("test")
public class TestController {

    @RequestMapping("signal")
    public R signal(){
        return R.ok("ok");
    }

}
