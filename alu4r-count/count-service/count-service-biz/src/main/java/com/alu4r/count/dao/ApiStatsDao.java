package com.alu4r.count.dao;

import com.alu4r.count.api.domain.ApiStats;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * api调用统计表(ApiStats)表数据库访问层
 *
 * @author makejava
 * @since 2020-11-26 15:06:03
 */
@Mapper
public interface ApiStatsDao extends BaseMapper<ApiStats> {

}