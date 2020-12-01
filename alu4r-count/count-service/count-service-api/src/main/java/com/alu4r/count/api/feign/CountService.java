package com.alu4r.count.api.feign;

import com.baomidou.mybatisplus.extension.api.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @description:
 * @author: alu4r
 * @date: 2020/12/1 20:15
 */
@Component
@FeignClient
public interface CountService {
    @PostMapping("countViewEvent")
    R countViewEvent(String apiId);
}
