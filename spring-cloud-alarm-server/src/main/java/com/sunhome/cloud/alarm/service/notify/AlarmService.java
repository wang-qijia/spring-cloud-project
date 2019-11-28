package com.sunhome.cloud.alarm.service.notify;

import com.sunhome.cloud.alarm.entiy.AlarmMessage;

import java.util.List;

public interface AlarmService {

    void notify(List<AlarmMessage> alarmMessages);
}
