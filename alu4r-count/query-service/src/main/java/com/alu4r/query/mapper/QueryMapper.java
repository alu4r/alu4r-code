package com.alu4r.query.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

/**
 * @description:
 * @author: alu4r
 * @date: 2020/11/28 12:50
 */
@Mapper
public interface QueryMapper {

    /**
     * apiId在某事件断内的访问数量
     * @param apiId
     * @param startTime 开始时间
     * @param endTime 结束时间
     * @return
     */
    Integer getViewsCount(@Param("apiId") String apiId, Date startTime, Date endTime);
}
