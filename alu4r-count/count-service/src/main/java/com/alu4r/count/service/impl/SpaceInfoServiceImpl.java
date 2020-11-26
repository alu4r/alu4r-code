package com.alu4r.count.service.impl;

import com.alu4r.count.dao.SpaceInfoDao;
import com.alu4r.count.entity.SpaceInfo;
import com.alu4r.count.service.SpaceInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * (SpaceInfo)表服务实现类
 *
 * @author makejava
 * @since 2020-11-26 15:06:13
 */
@Service("spaceInfoService")
public class SpaceInfoServiceImpl extends ServiceImpl<SpaceInfoDao, SpaceInfo> implements SpaceInfoService {

}