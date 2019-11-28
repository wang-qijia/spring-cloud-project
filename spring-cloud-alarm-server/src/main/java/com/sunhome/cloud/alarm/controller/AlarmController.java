package com.sunhome.cloud.alarm.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sunhome.cloud.alarm.entiy.AlarmMessage;
import com.sunhome.cloud.alarm.event.AlarmEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author wangqijia
 * @date 2019/11/28 15:18
 */
@RestController
@RequestMapping("alarm")
public class AlarmController {

    @Autowired
    ApplicationEventPublisher eventPublisher;

    @PostMapping("/notify")
    public void notify(@RequestBody List<AlarmMessage> alarmMessageList) {
        eventPublisher.publishEvent(new AlarmEvent(this, alarmMessageList));
    }
}
