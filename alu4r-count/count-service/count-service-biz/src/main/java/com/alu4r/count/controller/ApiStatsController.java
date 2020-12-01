package com.alu4r.count.controller;


import com.alu4r.count.api.domain.ApiStats;
import com.alu4r.count.service.ApiStatsService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * api调用统计表(ApiStats)表控制层
 *
 * @author makejava
 * @since 2020-11-26 15:06:07
 */
@RestController
@RequestMapping("apiStats")
public class ApiStatsController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private ApiStatsService apiStatsService;

    /**
     * 分页查询所有数据
     *
     * @param page     分页对象
     * @param apiStats 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<ApiStats> page, ApiStats apiStats) {
        return success(this.apiStatsService.page(page, new QueryWrapper<>(apiStats)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.apiStatsService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param apiStats 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody ApiStats apiStats) {
        return success(this.apiStatsService.save(apiStats));
    }

    /**
     * 修改数据
     *
     * @param apiStats 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody ApiStats apiStats) {
        return success(this.apiStatsService.updateById(apiStats));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.apiStatsService.removeByIds(idList));
    }
}