package com.area.controller;


import com.area.entity.TblArea;
import com.area.service.TblAreaService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * 用于备份的 行政区表(TblArea)表控制层
 *
 * @author makejava
 * @since 2020-12-16 14:14:59
 */
@RestController
@RequestMapping("tblArea")
public class TblAreaController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private TblAreaService tblAreaService;

    /**
     * 分页查询所有数据
     *
     * @param page    分页对象
     * @param tblArea 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<TblArea> page, TblArea tblArea) {
        return success(this.tblAreaService.page(page, new QueryWrapper<>(tblArea)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable("id") String id) {
        return success(this.tblAreaService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param tblArea 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody TblArea tblArea) {
        return success(this.tblAreaService.save(tblArea));
    }

    /**
     * 修改数据
     *
     * @param tblArea 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody TblArea tblArea) {
        return success(this.tblAreaService.updateById(tblArea));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.tblAreaService.removeByIds(idList));
    }
}