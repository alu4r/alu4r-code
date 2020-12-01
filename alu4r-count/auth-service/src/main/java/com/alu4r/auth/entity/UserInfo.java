package com.alu4r.auth.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * (UserInfo)表实体类
 *
 * @author makejava
 * @since 2020-11-29 16:04:42
 */
@SuppressWarnings("serial")
@Data
public class UserInfo extends Model<UserInfo> {

    /**
     * id
     */
    private String id;

    /**
     * 用户名
     */
    @NotBlank(message = "用户名不能为空")
    private String userName;
    /**
     * 密码
     */
    @NotBlank(message = "密码不能为空")
    private String passWord;

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