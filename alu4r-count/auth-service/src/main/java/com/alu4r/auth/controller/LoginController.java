package com.alu4r.auth.controller;

import com.alu4r.auth.entity.UserInfo;
import com.alu4r.auth.service.UserInfoService;
import com.alu4r.auth.utils.JwtUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @description:
 * @author: alu4r
 * @date: 2020/11/29 16:07
 */
@RestController
@RequestMapping("login")
public class LoginController {
    /**
     * 服务对象
     */
    @Autowired
    private UserInfoService userInfoService;

    /**
     * 分页查询所有数据
     *
     * @param userInfo 查询实体
     * @return 所有数据
     */
    @PostMapping
    public R login(UserInfo userInfo) {
        QueryWrapper<UserInfo> queryWrapper = new QueryWrapper();
        queryWrapper.eq("user_name",userInfo.getUserName())
                .eq("pass_word", userInfo.getPassWord());
        UserInfo one = userInfoService.getOne(queryWrapper);
        String token = JwtUtils.getToken(one);
        return R.ok(token);
    }
}
