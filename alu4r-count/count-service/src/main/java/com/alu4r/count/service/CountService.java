package com.alu4r.count.service;

/**
 * @description: 统计计数
 * @author: alu4r
 * @date: 2020/11/26 21:04
 */
public interface CountService {
    /**
     * 对apiId计数1次
     * @param apiId
     * @return
     */
    boolean countViewEvent(String apiId);

    /**
     * 根据事件进行计数
     * @param apiId
     * @param event
     * @return
     */
    boolean countEvent(String apiId, String event);
}
