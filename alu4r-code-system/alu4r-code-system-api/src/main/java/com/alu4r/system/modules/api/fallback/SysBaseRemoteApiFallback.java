package com.alu4r.system.modules.api.fallback;

import com.alibaba.fastjson.JSONObject;
import com.alu4r.common.core.system.vo.LoginUser;
import com.alu4r.common.core.vo.Result;
import com.alu4r.system.modules.api.SysBaseRemoteApi;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;


@Slf4j
public class SysBaseRemoteApiFallback implements SysBaseRemoteApi {

    @Setter
    private Throwable cause;

    @Override
    public Result<LoginUser> getUserByName(String username) {
        log.info("--获取用户信息异常--username:"+username, cause);
        return null;
    }

    @Override
    public void saveSysLog(JSONObject jsonObject) {
        log.info("--包存日志信息异常", cause);
    }

    @Override
    public String queryDictTextByKey(String code, String key) {
        log.info("--查询字典信息异常, code:"+code+", key:"+key, cause);
        return null;
    }

    @Override
    public String queryTableDictTextByKey(String table, String text, String code, String key) {
        log.info("--查询表字典信息异常, table:"+table+", text:"+text+", code:"+code+", key:"+key, cause);
        return null;
    }
}
