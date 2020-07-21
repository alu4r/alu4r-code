package com.alu4r.common.core.util.security.entity;

import cn.hutool.json.JSONObject;
import lombok.Data;

@Data
public class SecurityResp {
    private Boolean success;
    private JSONObject data;
}
