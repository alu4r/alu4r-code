package com.alu4r.count.service.impl;

import com.alu4r.count.dao.ApiStatsDao;
import com.alu4r.count.api.domain.ApiStats;
import com.alu4r.count.service.ApiStatsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * api调用统计表(ApiStats)表服务实现类
 *
 * @author makejava
 * @since 2020-11-26 15:06:06
 */
@Service("apiStatsService")
public class ApiStatsServiceImpl extends ServiceImpl<ApiStatsDao, ApiStats> implements ApiStatsService {

}