package com.sunhome.cloud.alarm.event;

import com.sunhome.cloud.alarm.entiy.AlarmMessage;
import org.springframework.context.ApplicationEvent;

import java.util.List;

/**
 * @author wangqijia
 * @date 2019/11/28 15:28
 */
public class AlarmEvent extends ApplicationEvent {

    private List<AlarmMessage> alarmMessages;

    public AlarmEvent(Object source, List<AlarmMessage> alarmMessages) {
        super(source);
        this.alarmMessages = alarmMessages;
    }

    public List<AlarmMessage> getAlarmMessages() {
        return alarmMessages;
    }

}
