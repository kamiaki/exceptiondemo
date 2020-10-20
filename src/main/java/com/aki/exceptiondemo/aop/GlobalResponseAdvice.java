package com.aki.exceptiondemo.aop;

import com.aki.exceptiondemo.po.ReturnMsg;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@Component
@ControllerAdvice
public class GlobalResponseAdvice implements ResponseBodyAdvice {
    @Override
    public boolean supports(MethodParameter methodParameter, Class aClass) {
        //返回true就到下面，返回false就终止不去下面
        return false;
    }

    @Override
    public Object beforeBodyWrite(Object o,
                                  MethodParameter methodParameter,
                                  MediaType mediaType,
                                  Class aClass,
                                  ServerHttpRequest serverHttpRequest,
                                  ServerHttpResponse serverHttpResponse) {
        //根据返回类型做判断 json 或 页面
        if (mediaType.equalsTypeAndSubtype(mediaType.APPLICATION_JSON)) {
            //写入状态码
            serverHttpResponse.setStatusCode(
                    HttpStatus.valueOf(((ReturnMsg)o).getCode())
            );
            //根据返回对象做封装
            if (o instanceof ReturnMsg){
                serverHttpResponse.setStatusCode(HttpStatus.OK);
            }
            return o;
        }
        return o;
    }
}
