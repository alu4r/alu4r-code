package com.alu4r.count.api.domain;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.io.Serializable;

/**
 * (SpaceInfo)表实体类
 *
 * @author makejava
 * @since 2020-11-26 15:06:09
 */
@SuppressWarnings("serial")
@Data
public class SpaceInfo extends Model<SpaceInfo> {

    private String id;
    //空间名称
    private String name;

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