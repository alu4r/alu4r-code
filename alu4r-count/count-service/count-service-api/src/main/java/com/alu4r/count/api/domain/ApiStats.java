package com.alu4r.count.api.domain;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * api调用统计表(ApiStats)表实体类
 *
 * @author makejava
 * @since 2020-11-26 15:06:02
 */
@SuppressWarnings("serial")
@Data
public class ApiStats extends Model<ApiStats> {

    private String id;
    //时间戳
    private Date timeStamp;
    //调用次数，一条记录表示调用一次，一遍此项为1
    private Integer count;

    public ApiStats(String id){
        this.id = id;
        this.timeStamp = new Date();
        this.count = 1;
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