package com.alu4r.query.controller;

import com.alu4r.query.service.QueryService;
import com.alu4r.query.utils.RedisUtil;
import com.baomidou.mybatisplus.extension.api.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.Date;

/**
 * @description: 查询服务
 * @author: alu4r
 * @date: 2020/11/19 23:06
 */
@Slf4j
@RestController
@RequestMapping("query")
@Validated
public class QueryController {
    @Autowired
    RedisUtil redisUtil;

    @Autowired
    QueryService queryService;

    /**
     * 根据id和时间段查询统计的数量
     * @param apiId
     * @param startTime
     * @param endTime
     * @return
     */
    @GetMapping("getViewsCount")
    public R getViewsCount(@Valid @NotBlank(message = "apiId 不能为空") String apiId, Date startTime, Date endTime){
        Integer viewsCount = queryService.getViewsCount(apiId, startTime, endTime);
        return R.ok(viewsCount);
    }

    /**
     * 根据id查询前一分钟的访问量
     * @param apiId
     * @return
     */
    @GetMapping("getViewsCountByApiId")
    public R getViewsCountByApiId(String apiId){
        StringBuilder key = new StringBuilder("count:" + apiId);
        Integer count = (Integer) redisUtil.get(key.toString());
        if(count == null){
            count = queryService.getViewsCountByApiId(apiId);
            redisUtil.set(key.toString(), count, 60);
            return R.ok(count);
        }
        return R.ok(count);
    }


}
