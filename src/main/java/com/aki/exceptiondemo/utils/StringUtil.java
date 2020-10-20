package com.aki.exceptiondemo.utils;

/**
 * 字符串处理工具类
 */
public class StringUtil {
    /**
     * 杀死null
     * @param inObj
     * @return
     */
    public static String killNull(Object inObj) {
        if (inObj == null) {
            return "";
        }
        return inObj.toString().trim();
    }

    /**
     * 是否为空
     * @param s
     * @return
     */
    public static boolean isNullStr(String s) {
        if (s == null || s.trim().length() <= 0) {
            return true;
        } else {
            return false;
        }
    }
}
