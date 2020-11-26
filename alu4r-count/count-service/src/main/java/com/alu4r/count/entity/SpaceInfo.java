package com.alu4r.count.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;

/**
 * (SpaceInfo)表实体类
 *
 * @author makejava
 * @since 2020-11-26 15:06:09
 */
@SuppressWarnings("serial")
public class SpaceInfo extends Model<SpaceInfo> {

    private String id;
    //空间名称
    private String name;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取主键值
     *
     * @return 主键值
     */
    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}