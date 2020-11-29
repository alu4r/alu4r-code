package com.alu4r.auth.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;

/**
 * (UserInfo)表实体类
 *
 * @author makejava
 * @since 2020-11-29 16:04:42
 */
@SuppressWarnings("serial")
public class UserInfo extends Model<UserInfo> {

    private String id;
    //用户名
    private String userName;
    //密码
    private String passWord;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
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