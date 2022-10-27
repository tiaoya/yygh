package com.zhong.yygh.common.handler;

import com.zhong.yygh.common.exception.YyghException;
import com.zhong.yygh.common.result.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLException;

/**
 * @author : zhong
 * @Description :
 * @create : 2022/10/22-23:05
 */
@RestControllerAdvice //凡是由@ControllerAdvice 标记的类都表示全局异常处理类
@Slf4j
public class GlobalExceptionHandler {


    @ExceptionHandler(value = Exception.class )//粒度： 捕捉全部异常
    public R handleException(Exception ex){
        ex.printStackTrace();//输出异常：日志文件
        log.error(ex.getMessage());
        return R.error().message(ex.getMessage());
    }

    @ExceptionHandler(value = RuntimeException.class )//细粒度的异常处理   捕捉特定异常
    public R handleRuntimeException(RuntimeException ex){
        ex.printStackTrace();//输出异常：日志文件
        log.error(ex.getMessage());
        return R.error().message("编译时异常");
    }

    @ExceptionHandler(value = SQLException.class )//细粒度的异常处理    捕捉特定异常
    public R handleSqlExcepiton(SQLException ex){
        ex.printStackTrace();//输出异常：日志文件
        log.error(ex.getMessage());
        return R.error().message("Sql异常");
    }

    @ExceptionHandler(value = ArithmeticException.class )//细粒度的异常处理 捕捉特定异常
    public R handleArithmeticException(ArithmeticException ex){
        ex.printStackTrace();//输出异常：日志文件
        log.error(ex.getMessage());
        return R.error().message("数学异常");
    }


    @ExceptionHandler(value = YyghException.class )//细粒度的异常处理   捕捉自定义异常
    public R handleYyghException(YyghException ex){
        ex.printStackTrace();//输出异常：日志文件
        log.error(ex.getMessage());
        return R.error().message(ex.getMessage()).code(ex.getCode());
    }
}
