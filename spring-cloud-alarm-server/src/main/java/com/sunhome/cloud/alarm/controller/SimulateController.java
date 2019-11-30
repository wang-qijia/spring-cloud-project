package com.sunhome.cloud.alarm.controller;

import com.sunhome.cloud.alarm.entiy.User;
import com.sunhome.cloud.alarm.service.simulat.SimulateService;
import org.apache.skywalking.apm.toolkit.trace.TraceContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;
import java.util.concurrent.TimeoutException;

/**
 * 数据模拟-产生调用链
 *
 * @author wangqijia
 * @date 2019/11/28 15:18
 */
@RestController
@RequestMapping("simulate")
public class SimulateController {

    private static Logger logger = LoggerFactory.getLogger(SimulateController.class);

    @Autowired
    private SimulateService simulateService;


    @GetMapping("/readTimeout")
    public String readTimeout() throws InterruptedException, TimeoutException {

        int timeout = new Random().nextInt(10);
        logger.info("readTimeout:{}", timeout);
        if (timeout > 5) {
            throw new TimeoutException("request timeout");
        }
        Thread.sleep(3 * 1000);
        return TraceContext.traceId();
    }

    @GetMapping("/readTimeoutv1")
    public String readTimeoutv1() throws InterruptedException, TimeoutException {
        int timeout = new Random().nextInt(10);
        if (timeout > 5) {
            throw new TimeoutException("request timeout");
        }
        Thread.sleep(3 * 1000);
        return TraceContext.traceId();
    }

    @GetMapping("/error")
    public void error() {
        int num = 1 / 0;
    }

    @GetMapping("/query")
    public User query() {
        return simulateService.query();
    }


}
