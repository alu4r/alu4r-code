package com.alu4r.query.service;

import java.util.Date;

/**
 * @description:
 * @author: alu4r
 * @date: 2020/11/28 12:45
 */
public interface QueryService {
    /**
     * apiId在某事件断内的访问数量
     * @param apiId
     * @param startTime 开始时间
     * @param endTime 结束时间
     * @return
     */
    Integer getViewsCount(String apiId, Date startTime, Date endTime);
}
