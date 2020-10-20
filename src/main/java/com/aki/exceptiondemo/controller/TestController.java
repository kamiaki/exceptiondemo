package com.aki.exceptiondemo.controller;

import com.aki.exceptiondemo.enums.EnumMsg;
import com.aki.exceptiondemo.exceptions.CustomException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class TestController {

    @RequestMapping(value = "test1")
    public Object test1() {
        Map map = new HashMap();
        map.put("aaa", "111");
        if (true) throw new CustomException(EnumMsg.FAIL_0);
        return map;
    }
}
