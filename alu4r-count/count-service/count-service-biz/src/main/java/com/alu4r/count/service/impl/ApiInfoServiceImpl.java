package com.alu4r.count.service.impl;

import com.alu4r.count.dao.ApiInfoDao;
import com.alu4r.count.entity.ApiInfo;
import com.alu4r.count.service.ApiInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * api基本信息(ApiInfo)表服务实现类
 *
 * @author makejava
 * @since 2020-11-26 15:05:58
 */
@Service("apiInfoService")
public class ApiInfoServiceImpl extends ServiceImpl<ApiInfoDao, ApiInfo> implements ApiInfoService {

}