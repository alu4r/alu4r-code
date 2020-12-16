package com.area.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.Date;


/**
 * 用于备份的 行政区表(TblArea)表实体类
 *
 * @author makejava
 * @since 2020-12-16 14:14:55
 */
@TableName("tbl_area_test")
@SuppressWarnings("serial")
@Data
public class TblArea extends Model<TblArea> {
    //主键
    @TableId
    private String id;
    //创建时间
    private Date createTime;
    //修改时间
    private Date updateTime;
    //区域名称
    private String areaName;
    //左值
    private Integer lft;
    //级别
    private Integer lv;
    //上级区域
    private String parentId;
    //右值
    private Integer rgt;
    //创建人
    private Object creator;
    //创建人标识
    private Object creatorSign;
    //最后修改人
    private Object operator;
    //最后修改人标识
    private Object operatorSign;

}