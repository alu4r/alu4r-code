package com.alu4r.query.service.impl;

import com.alu4r.query.mapper.QueryMapper;
import com.alu4r.query.service.QueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @description:
 * @author: alu4r
 * @date: 2020/11/28 12:45
 */
@Service
public class QueryServiceImpl implements QueryService {

    @Autowired
    QueryMapper queryMapper;
    /**
     * apiId在某事件断内的访问数量
     *
     * @param apiId
     * @param startTime 开始时间
     * @param endTime 结束时间
     * @return
     */
    @Override
    public Integer getViewsCount(String apiId, Date startTime, Date endTime) {
        Integer count = queryMapper.getViewsCount(apiId, startTime, endTime);
        return count;
    }
}
