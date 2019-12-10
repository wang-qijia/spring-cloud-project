package com.sunhome.cloud.doctor.exception;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.fastjson.JSONObject;

/**
 * @author wangqijia
 * @date 2019/12/10 16:20
 */
public class ExceptionUtil {

    public static String exceptionHandler(BlockException exception) {
        JSONObject json = new JSONObject();
        json.put("msg", "请求频繁");
        json.put("code", 100);
        return json.toString();
    }

    public static String fallbackHandler(Throwable throwable) {
        System.out.println("fallback");
        JSONObject json = new JSONObject();
        json.put("msg", "服务降级返回");
        json.put("code", 100);
        return json.toString();
    }
}
