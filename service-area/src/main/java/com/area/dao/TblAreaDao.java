package com.area.dao;

import com.area.entity.TblArea;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用于备份的 行政区表(TblArea)表数据库访问层
 *
 * @author makejava
 * @since 2020-12-16 14:14:56
 */
@Mapper
public interface TblAreaDao extends BaseMapper<TblArea> {

}