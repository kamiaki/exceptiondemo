package com.aki.exceptiondemo.exceptions;


import com.aki.exceptiondemo.enums.EnumMsg;
import lombok.Data;

@Data
public class CustomException extends RuntimeException {
    private EnumMsg enumMsg;
    private String msg;

    public CustomException(EnumMsg enumMsg){
        super(enumMsg.getMsg());
        this.enumMsg = enumMsg;
    }

    public CustomException(String msg){
        super(msg);
        this.msg = msg;
    }
}
