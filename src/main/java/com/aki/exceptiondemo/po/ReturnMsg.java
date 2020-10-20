package com.aki.exceptiondemo.po;


import com.aki.exceptiondemo.enums.EnumMsg;
import com.aki.exceptiondemo.utils.StringUtil;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 通用返回消息对象
 *
 * @param <T>
 * @author wangzhe
 */
@Data
@AllArgsConstructor
public class ReturnMsg<T> {
    private boolean success;
    private int code;
    private String msg;
    private T data;

    public ReturnMsg(EnumMsg msgEnum) {
        this.success = msgEnum.isSuccess();
        this.code = msgEnum.getCode();
        this.msg = msgEnum.getMsg();
    }

    public void setReturnMsg(EnumMsg msgEnum) {
        this.success = msgEnum.isSuccess();
        this.code = msgEnum.getCode();
        this.msg = msgEnum.getMsg();
    }

    public void setSuccess(int code, String msg) {
        this.success = true;
        this.code = code;
        this.msg = StringUtil.killNull(msg);
    }

    public void setFail(int code, String msg) {
        this.success = false;
        this.code = code;
        this.msg = StringUtil.killNull(msg);
    }
}
