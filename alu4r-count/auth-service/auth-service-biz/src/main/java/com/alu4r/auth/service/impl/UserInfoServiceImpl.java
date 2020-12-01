package com.alu4r.auth.service.impl;

import com.alu4r.auth.dao.UserInfoDao;
import com.alu4r.auth.entity.UserInfo;
import com.alu4r.auth.service.UserInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * (UserInfo)表服务实现类
 *
 * @author makejava
 * @since 2020-11-29 16:04:48
 */
@Service("userInfoService")
public class UserInfoServiceImpl extends ServiceImpl<UserInfoDao, UserInfo> implements UserInfoService {

}