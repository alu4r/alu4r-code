package com.alu4r.count.dao;

import com.alu4r.count.entity.ApiInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * api基本信息(ApiInfo)表数据库访问层
 *
 * @author makejava
 * @since 2020-11-26 15:05:54
 */
@Mapper
public interface ApiInfoDao extends BaseMapper<ApiInfo> {

}