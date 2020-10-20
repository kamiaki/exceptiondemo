package com.aki.exceptiondemo.aop;


import com.aki.exceptiondemo.enums.EnumMsg;
import com.aki.exceptiondemo.exceptions.CustomException;
import com.aki.exceptiondemo.po.ReturnMsg;
import com.aki.exceptiondemo.utils.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * DefaultGlobalExceptionHandlerAdvice
 *
 * @author wz
 **/

@ControllerAdvice(value = "com.aki.exceptiondemo.controller")
@Slf4j
public class DefaultGlobalExceptionHandlerAdvice {

    /**
     * 自定义异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(CustomException.class)
    @ResponseBody
    public ReturnMsg CustomException(CustomException e) {
        e.printStackTrace();
        log.error(e.getMessage());
        ReturnMsg returnMsg;
        //有枚举用枚举,没有枚举用msg
        if(null != e.getEnumMsg()) {
            returnMsg = new ReturnMsg(e.getEnumMsg());
        }else {
            returnMsg = new ReturnMsg(EnumMsg.FAIL_0);
            returnMsg.setMsg(StringUtil.killNull(e.getMsg()));
        }
        return returnMsg;
    }

    /**
     * 基础异常.
     *
     * @param ex
     * @return CommonResult
     */
    @ExceptionHandler(value = {Exception.class})
    @ResponseBody
    public ReturnMsg exception(Exception ex) {
        ex.printStackTrace();
        log.error(ex.getMessage());
        ReturnMsg returnMsg = new ReturnMsg(EnumMsg.FAIL_0);
        returnMsg.setMsg(new StringBuffer("系统异常:").append(ex.getMessage()).toString());
        return returnMsg;
    }
}
