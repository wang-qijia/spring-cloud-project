package com.sunhome.cloud.gateway.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangqijia
 * @date 2019/11/21 17:18
 */
@RestController
public class FallbackController {

    @GetMapping("fallback")
    public ResponseEntity fallback() {
        return ResponseEntity.ok("fail");
    }



}
