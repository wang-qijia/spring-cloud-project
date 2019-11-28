package com.sunhome.cloud.alarm.service.notify;

import com.alibaba.fastjson.JSON;
import com.sunhome.cloud.alarm.entiy.AlarmMessage;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wangqijia
 * @date 2019/11/28 15:36
 */
@Service
public class DingtalkAlarmService implements AlarmService {

    @Override
    public void notify(List<AlarmMessage> alarmMessages) {
        System.out.println("dingTalk send" + JSON.toJSONString(alarmMessages));
    }

}
