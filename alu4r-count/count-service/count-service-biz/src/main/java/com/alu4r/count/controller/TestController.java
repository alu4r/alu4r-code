package com.alu4r.count.controller;

import cn.hutool.core.util.StrUtil;
import cn.hutool.core.util.URLUtil;
import com.alu4r.count.entity.Test;
import com.baomidou.mybatisplus.extension.api.R;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

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
        String url = "http://znyj.nftec.agri.cn/api/service-styy/styy";
        String ref = URLUtil.toUrlForHttp(url).getRef();
        return R.ok("成功发送信号！");
    }

    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("key", "value");
        Test test = new Test(map);
        Map<String, String> map1 = test.getMap();
        map1.put("key", "1111111");

        System.out.println(test);

    }
}
