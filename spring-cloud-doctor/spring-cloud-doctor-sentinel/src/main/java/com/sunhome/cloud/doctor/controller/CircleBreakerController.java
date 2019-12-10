package com.sunhome.cloud.doctor.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.sunhome.cloud.doctor.exception.ExceptionUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author wangqijia
 * @date 2019/12/9 17:52
 */
@RestController
@RequestMapping("/circleBreaker")
public class CircleBreakerController {

    @GetMapping("fallback")
    @SentinelResource(value = "fallback", fallback = "fallbackHandler", fallbackClass = ExceptionUtil.class)
    public String fallback() {
        if (true) {
            throw new RuntimeException("error ..");
        }
        return "fallback";
    }


}
