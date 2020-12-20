package com.alu4r.query.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alu4r.core.exception.BizException;
import com.alu4r.query.handler.CustomerBlockHandler;
import com.baomidou.mybatisplus.extension.api.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public R testA() {
        log.info("===========A请求成功============");
        return R.ok("A请求成功");
    }

    @GetMapping("testB")
    public R testB() {
        log.info("===========B请求成功============");
        return R.ok("B请求成功");
    }

    @GetMapping("testC")
    public R testC() {
        log.info("===========C异常比例============");
        int i = 10 / 0;
        return R.ok("C异常比例");
    }

    @GetMapping("testD")
    public R testD() {
        log.info("===========D异常数============");
        int i = 10 / 0;
        return R.ok("D异常数");
    }

    @GetMapping("/testHotKey")
    @SentinelResource(value = "testHotKey", blockHandler = "dealTestHotKey")
    public R testHotKey(@RequestParam(value = "p1", required = false) String p1,
                        @RequestParam(value = "p2", required = false) String p2) {
        //int age = 10/0;
        return R.ok("热点数据key");
    }

    //触发后执行的方法
    public R dealTestHotKey(String p1, String p2, BlockException exception) {
        //sentinel系统默认的提示：Blocked by Sentinel (flow limiting)
        return R.ok("Sentinel流量防卫兵接手");
    }


    @GetMapping("customerBlockHandler")
    @SentinelResource(value = "customerBlockHandler",
            blockHandlerClass = CustomerBlockHandler.class,
            blockHandler = "handlerException2")
    public R customerBlockHandler() {
        return R.ok("用户自定义限流处理器");
    }


    @RequestMapping("signal")
    public R signal() {
        return R.ok("ok");
    }

}
