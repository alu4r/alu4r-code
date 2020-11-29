package com.alu4r.auth.dao;

import com.alu4r.auth.entity.UserInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * (UserInfo)表数据库访问层
 *
 * @author makejava
 * @since 2020-11-29 16:04:45
 */
@Mapper
public interface UserInfoDao extends BaseMapper<UserInfo> {

}