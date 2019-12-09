package com.sunhome.cloud.doctor.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangqijia
 * @date 2019/12/9 17:52
 */
@RestController
public class SentinelTestController {

    @GetMapping("read")
    public String read() {
        return "read";
    }
}
