package com.alu4r.query.controller;

import com.alu4r.query.service.QueryService;
import com.baomidou.mybatisplus.extension.api.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @description: 查询服务
 * @author: alu4r
 * @date: 2020/11/19 23:06
 */
@RestController
@RequestMapping("/query")
public class QueryController {

    @Autowired
    QueryService queryService;

    @GetMapping("/test")
    public String test(){
        return "查询测试成功！";
    }

    /**
     * 根据id和时间段查询统计的数量
     * @param apiId
     * @param startTime
     * @param endTime
     * @return
     */
    @GetMapping("getViewsCount")
    public R getViewsCount(String apiId, Date startTime, Date endTime){
        Integer viewsCount = queryService.getViewsCount(apiId, startTime, endTime);
        return R.ok(viewsCount);
    }


}
