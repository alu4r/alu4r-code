package com.area.service;

import com.area.entity.TblArea;
import com.baomidou.mybatisplus.extension.service.IService;
import io.swagger.models.auth.In;

import java.util.List;

/**
 * 用于备份的 行政区表(TblArea)表服务接口
 *
 * @author makejava
 * @since 2020-12-16 14:14:57
 */
public interface TblAreaService extends IService<TblArea> {

    /**
     * 查询父id相同的数量
     * @param id
     * @return
     */
    int countByParentId(String id);

    /**
     * 根据父id获取
     * @param parentId
     * @return
     */
    List<TblArea> listByParentId(String parentId);

    /**
     * 根据id获取
     * @param Id
     * @return
     */
    List<TblArea> listById(String Id);

    /**
     * 修改左值
     * @param lft
     * @return
     */
    boolean updateLft(TblArea tblArea, Integer lft);

    /**
     * 修改右值
     * @param rgt
     * @return
     */
    boolean updateRgt(TblArea tblArea, Integer rgt);

}