package com.alu4r.count.controller;

import com.alu4r.count.service.CountService;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

/**
 * @description: 计数控制器
 * @author: alu4r
 * @date: 2020/11/26 20:57
 */
@RestController
@RequestMapping("count")
@Validated
public class CountController extends ApiController {

    @Autowired
    CountService countService;

    /**
     * 根据id对Api进行计数
     *
     * @param apiId
     * @return
     */
    @PostMapping("countViewEvent")
    public R countViewEvent(@Valid @NotBlank(message = "apiId 不能为空") String apiId) {
        return R.ok(countService.countViewEvent(apiId));
    }
}
