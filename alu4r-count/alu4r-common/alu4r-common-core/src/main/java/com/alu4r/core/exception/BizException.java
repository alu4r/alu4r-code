package com.alu4r.core.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @description:
 * @author: alu4r
 * @date: 2020/12/2 15:59
 */
@Data
@AllArgsConstructor
public class BizException extends RuntimeException{

    /**
     * 错误码
     */
    protected String errorCode;
    /**
     * 错误信息
     */
    protected String errorMsg;


}
