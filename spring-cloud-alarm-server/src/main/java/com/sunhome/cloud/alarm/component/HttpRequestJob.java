package com.sunhome.cloud.alarm.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Random;

/**
 * 模拟请求本地端点
 *
 * @author wangqijia
 * @date 2019/12/6 15:39
 */
@Component
public class HttpRequestJob {

    private static final Logger LOGGER = LoggerFactory.getLogger(HttpRequestJob.class);

    @Autowired
    private RestTemplate restTemplate;

    private static final String HOST = "http://127.0.0.1:8099";

    private static final String GET_ENDPOING = "/simulate/get/{name}";

    private Random random = new Random(10000);


//    @Scheduled(fixedRate = 1000)
//    public void requestEndpoint() {
//        int num = random.nextInt();
//        System.out.println(num);
//        ResponseEntity<String> entity = restTemplate.getForEntity(buildPath(GET_ENDPOING.replace("{name}", String.valueOf(num))), String.class);
//        LOGGER.info("job result:{}", entity.getBody());
//
//    }


    private String buildPath(String endpoint) {
        return HOST + endpoint;
    }


}
