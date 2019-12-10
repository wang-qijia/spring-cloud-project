package com.sunhome.cloud.doctor.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sunhome.cloud.doctor.exception.ExceptionUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangqijia
 * @date 2019/12/9 17:52
 */
@RestController
@RequestMapping("/rateLimit")
public class RateLimitController {

    @GetMapping("byUrl")
    @SentinelResource(value = "byUrl", blockHandler = "exceptionHandler", blockHandlerClass = {ExceptionUtil.class})
    public String byUrl() {
        return "byUrl";
    }


}
