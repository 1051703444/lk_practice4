package com.lkcoffee.handler;

import com.lkcoffee.exception.DeletionNotAllowedException;
import com.lkcoffee.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLIntegrityConstraintViolationException;

/**
 * 全局异常处理器，处理项目中抛出的业务异常
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    /**
     * 处理SQL异常
     * @param ex
     * @return
     */
    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public Result exceptionHandler(SQLIntegrityConstraintViolationException ex){
        String message = ex.getMessage();
        log.error(message);
        if(message.contains("Cannot add or update a child row")){
            return Result.error("Cannot add or update a child row");
        }else{
            return Result.error("未知错误");
        }

    }

    @ExceptionHandler(DeletionNotAllowedException.class)
    public Result exceptionHandler(DeletionNotAllowedException ex){
        String message = ex.getMessage();
        log.error(message);
        return Result.error(message);
    }


}
