package com.area.controller;

import com.area.entity.TblArea;
import com.area.service.TblAreaService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description:
 * @author: alu4r
 * @date: 2020/12/16 14:56
 */
@Slf4j
@RestController
@RequestMapping("areaUpdate")
public class AreaUpdate extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private TblAreaService tblAreaService;

    @GetMapping("test")
    public R test() {
        return R.ok(tblAreaService.listByParentId("0"));
    }

    @PutMapping("init")
    public R init() {
        TblArea tblArea = new TblArea();
        tblArea.setId("0");
        execute(tblArea, 0);
        return R.ok("操作成功");
    }

    public int execute(TblArea tblArea, int flag){
        List<TblArea> tblAreas = tblAreaService.listByParentId(tblArea.getId());
        if(tblAreas.size() <= 0){
            return ++flag;
        }
        for (TblArea tblAreaTemp : tblAreas) {
            flag++;
            //修改左值
            tblAreaService.updateLft(tblAreaTemp, flag);
            log.info("修改{}的左值为{}",tblAreaTemp.getAreaName(), flag);
            flag = execute(tblAreaTemp, flag);
            //修改右值
            tblAreaService.updateRgt(tblAreaTemp, flag);
            log.info("修改{}的右值为{}",tblAreaTemp.getAreaName(), flag);
        }
        return ++flag;
    }
}
