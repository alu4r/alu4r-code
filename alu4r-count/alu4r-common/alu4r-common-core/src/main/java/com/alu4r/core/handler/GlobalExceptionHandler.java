package com.alu4r.core.handler;

import com.alu4r.core.exception.BizException;
import com.baomidou.mybatisplus.extension.api.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.Size;

/**
 * @description:
 * @author: alu4r
 * @date: 2020/12/2 15:57
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = BizException.class)
    @ResponseBody
    public R bizExceptionHandler(BizException e){
        log.info("发生业务异常！原因是：{}", e.getErrorMsg());
        return R.failed("发生业务异常");
    }
}
