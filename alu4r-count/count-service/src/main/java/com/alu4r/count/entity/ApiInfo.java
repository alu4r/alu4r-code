package com.alu4r.count.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;

/**
 * api基本信息(ApiInfo)表实体类
 *
 * @author makejava
 * @since 2020-11-26 15:05:50
 */
@SuppressWarnings("serial")
public class ApiInfo extends Model<ApiInfo> {

    private String id;
    //api名称
    private String name;
    //空间id
    private String spaceId;


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

    public String getSpaceId() {
        return spaceId;
    }

    public void setSpaceId(String spaceId) {
        this.spaceId = spaceId;
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