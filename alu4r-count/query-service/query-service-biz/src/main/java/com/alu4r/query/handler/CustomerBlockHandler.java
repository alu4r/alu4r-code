package com.alu4r.query.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.baomidou.mybatisplus.extension.api.R;


/**
 * @description:
 * @author: alu4r
 * @date: 2020/12/19 20:34
 */
public class CustomerBlockHandler {

    public static R handlerException(BlockException exception) {

        return R.failed("自定义异常1");
    }

    public static R handlerException2(BlockException exception) {

        return R.failed("自定义异常2");
    }

}
