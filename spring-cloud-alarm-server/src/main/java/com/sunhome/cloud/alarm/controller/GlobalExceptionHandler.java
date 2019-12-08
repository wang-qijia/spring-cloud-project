package com.sunhome.cloud.alarm.controller;

import com.alibaba.fastjson.JSONObject;
import org.apache.skywalking.apm.toolkit.trace.ActiveSpan;
import org.apache.skywalking.apm.toolkit.trace.Trace;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * 模拟业务全局捕获场景
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    private static Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @Trace
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public JSONObject defaultErrorHandler(HttpServletRequest request, Exception e) {
        logger.error("request url:[{}],error desc:[{}] ", request.getRequestURL().toString(), e.getMessage() == null ? "服务器异常" : e.getMessage());
        ActiveSpan.error();

        JSONObject result = new JSONObject();
        result.put("result", 100);
        result.put("msg", e.getMessage() == null ? "服务器异常" : e.getMessage());
        return result;

    }


}
