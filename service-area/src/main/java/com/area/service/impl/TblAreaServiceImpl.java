package com.area.service.impl;

import cn.hutool.core.util.StrUtil;
import com.area.dao.TblAreaDao;
import com.area.entity.TblArea;
import com.area.service.TblAreaService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用于备份的 行政区表(TblArea)表服务实现类
 *
 * @author makejava
 * @since 2020-12-16 14:14:58
 */
@Service("tblAreaService")
public class TblAreaServiceImpl extends ServiceImpl<TblAreaDao, TblArea> implements TblAreaService {
    /**
     * 查询父id相同的数量
     *
     * @param parentId
     * @return
     */
    @Override
    public int countByParentId(String parentId) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq(StrUtil.isEmpty(parentId), "PARENT_ID", parentId);
        int count = count(queryWrapper);
        return count;
    }

    /**
     * 根据父id获取
     *
     * @param parentId
     * @return
     */
    @Override
    public List<TblArea> listByParentId(String parentId) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq(StrUtil.isNotEmpty(parentId), "PARENT_ID", parentId);
        return list(queryWrapper);
    }

    /**
     * 根据id获取
     *
     * @param Id
     * @return
     */
    @Override
    public List<TblArea> listById(String Id) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq(StrUtil.isNotEmpty(Id), "id", Id);
        return list(queryWrapper);
    }

    /**
     * 修改左值
     *
     * @param lft
     * @return
     */
    @Override
    public boolean updateLft(TblArea tblArea, Integer lft) {
        tblArea.setLft(lft);
        return updateById(tblArea);
    }

    /**
     * 修改右值
     *
     * @param tblArea
     * @param rgt
     * @return
     */
    @Override
    public boolean updateRgt(TblArea tblArea, Integer rgt) {
        tblArea.setRgt(rgt);
        return updateById(tblArea);
    }
}