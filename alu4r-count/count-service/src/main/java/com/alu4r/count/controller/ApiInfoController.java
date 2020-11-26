package com.alu4r.count.controller;


import com.alu4r.count.entity.ApiInfo;
import com.alu4r.count.service.ApiInfoService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * api基本信息(ApiInfo)表控制层
 *
 * @author makejava
 * @since 2020-11-26 15:05:59
 */
@RestController
@RequestMapping("apiInfo")
public class ApiInfoController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private ApiInfoService apiInfoService;

    /**
     * 分页查询所有数据
     *
     * @param page    分页对象
     * @param apiInfo 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<ApiInfo> page, ApiInfo apiInfo) {
        return success(this.apiInfoService.page(page, new QueryWrapper<>(apiInfo)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.apiInfoService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param apiInfo 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody ApiInfo apiInfo) {
        return success(this.apiInfoService.save(apiInfo));
    }

    /**
     * 修改数据
     *
     * @param apiInfo 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody ApiInfo apiInfo) {
        return success(this.apiInfoService.updateById(apiInfo));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.apiInfoService.removeByIds(idList));
    }
}