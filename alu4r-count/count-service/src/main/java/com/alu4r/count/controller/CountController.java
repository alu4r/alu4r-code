package com.alu4r.count.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: 计数控制器
 * @author: alu4r
 * @date: 2020/11/19 23:01
 */
@RestController
@RequestMapping("/count")
public class CountController {

    @GetMapping("/test")
    public String test(){
        return "计数测试成功！";
    }
    
}
