package com.aki.exceptiondemo.enums;

/**
 * 通用返回枚举对象
 *  * @author wangzhe
 */
public enum EnumMsg {
    SUCCESS_0(true,200,"成功")

    ,FAIL_0(false,500,"异常")
    ;

    private boolean isSuccess;
    private int code;
    private String msg;

    EnumMsg(boolean isSuccess, int code, String msg) {
        this.isSuccess = isSuccess;
        this.code = code;
        this.msg = msg;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public static EnumMsg getEnumByCode(int code) {
        for (EnumMsg e : EnumMsg.values()) {
            if (e.getCode() == code) {
                return e;
            }
        }
        return null;
    }

    public static String getMsgByCode(int code) {
        for (EnumMsg e : EnumMsg.values()) {
            if (e.getCode() == code) {
                return e.getMsg();
            }
        }
        return null;
    }

    public static boolean isExistByCode(int code) {
        for (EnumMsg e : EnumMsg.values()) {
            if (e.getCode() == code) {
                return true;
            }
        }
        return false;
    }
}
