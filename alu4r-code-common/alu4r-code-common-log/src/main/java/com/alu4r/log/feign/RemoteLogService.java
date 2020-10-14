package com.alu4r.log.feign;

import com.alu4r.log.domain.SysLogininfor;
import com.alu4r.log.domain.SysOperLog;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * 日志Feign服务层
 * 
 * @author zmr
 * @date 2019-05-20
 */
@FeignClient(name = "service-log")
public interface RemoteLogService
{
    @PostMapping("operLog/save")
    public void insertOperlog(@RequestBody SysOperLog operLog);

    @PostMapping("logininfor/save")
    public void insertLoginlog(@RequestBody SysLogininfor logininfor);
}
