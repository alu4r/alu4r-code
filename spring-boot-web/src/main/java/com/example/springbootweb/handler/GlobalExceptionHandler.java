package com.example.springbootweb.handler;

import cn.hutool.core.util.StrUtil;
import com.example.springbootweb.vo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;
import java.util.List;
import java.util.Set;

/**
 * 全局异常处理器
 *
 * @author liulu40
 **/
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    /**
     * 全局异常响应
     *
     * @param ex 异常信息
     * @return 响应Result
     */
    @ExceptionHandler(value = Exception.class)
    public Result<Object> globalExceptionHandler(Exception ex) {
        String message = ex.getMessage();
        log.error("发生异常:{}", message);
        return Result.error(message);
    }

    /**
     * 校验实体类
     *
     * @param ex 异常信息
     * @return 响应Result
     */
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public Result<Object> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException ex) {
        BindingResult bindingResult = ex.getBindingResult();
        StringBuilder sb = new StringBuilder();
        List<FieldError> fieldErrors = bindingResult.getFieldErrors();
        for (FieldError fieldError : fieldErrors) {
            sb.append(fieldError.getDefaultMessage())
                    .append(StrUtil.COMMA);
        }
        String message = StrUtil.removeSuffix(sb.toString(), StrUtil.COMMA);
        log.error("数据校验失败:{}", message);
        return Result.error(HttpStatus.BAD_REQUEST.value(), message);
    }

    /**
     * 校验单个参数
     *
     * @param ex 单个参数校验异常
     * @return 响应Result
     */
    @ExceptionHandler(value = ValidationException.class)
    public Result<Object> bindExceptionHandler(ValidationException ex) {
        StringBuilder sb = new StringBuilder();
        if (ex instanceof ConstraintViolationException) {
            ConstraintViolationException exs = (ConstraintViolationException) ex;
            Set<ConstraintViolation<?>> violations = exs.getConstraintViolations();
            for (ConstraintViolation<?> item : violations) {
                sb.append(item.getMessageTemplate()).append(StrUtil.COMMA);
            }
        }
        String message = StrUtil.removeSuffix(sb.toString(), StrUtil.COMMA);
        log.error("数据校验失败:{}", message);
        return Result.error(HttpStatus.BAD_REQUEST.value(), message);
    }
}
