package com.alu4r.count.service.impl;

import com.alu4r.count.dao.ApiStatsDao;
import com.alu4r.count.entity.ApiStats;
import com.alu4r.count.service.CountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author: alu4r
 * @date: 2020/11/26 21:06
 */
@Service
public class CountServiceImpl implements CountService {

    @Autowired
    ApiStatsDao apiStatsDao;
    /**
     * 对apiId计数1次
     *
     * @param apiId
     * @return
     */
    @Override
    public boolean countViewEvent(String apiId) {
        ApiStats apiStats = new ApiStats(apiId);
        int insert = apiStatsDao.insert(apiStats);
        return insert > 0;
    }

    /**
     * 根据事件进行计数
     *
     * @param apiId
     * @param event
     * @return
     */
    @Override
    public boolean countEvent(String apiId, String event) {
        return false;
    }
}
