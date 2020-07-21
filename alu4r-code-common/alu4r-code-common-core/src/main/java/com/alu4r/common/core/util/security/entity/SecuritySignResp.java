package com.alu4r.common.core.util.security.entity;

import lombok.Data;

@Data
public class SecuritySignResp {
    private String data;
    private String signData;
    private String aesKey;
}
