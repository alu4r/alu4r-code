package com.alu4r.query.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: 查询服务
 * @author: alu4r
 * @date: 2020/11/19 23:06
 */
@RestController
@RequestMapping("/query")
public class QueryController {

    @GetMapping("/test")
    public String test(){
        return "查询测试成功！";
    }
}
