package com.fms.mms.handler;

import com.fms.mms.exception.MtsException;
import com.fms.mms.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class GlobExceptionHandler {

    /**
     * 处理自定义异常
     * @param ex
     * @return
     */
    @ExceptionHandler(MtsException.class)
    public R handlerMtsException(MtsException ex){
        log.error(ex.getMsg());
        ex.printStackTrace();
        return R.error().message(ex.getMsg());
    }

    /**
     * 处理全局异常
     * @param ex
     * @return
     */
    @ExceptionHandler(Exception.class)
    public R handlerException(Exception ex){
        log.error(ex.getMessage());
        ex.printStackTrace();
        return R.error().message(ex.getMessage());
    }

}
