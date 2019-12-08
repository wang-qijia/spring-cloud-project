package com.sunhome.cloud.alarm.service.notify;

import com.sunhome.cloud.alarm.entiy.AlarmMessage;
import com.sunhome.cloud.alarm.event.AlarmEvent;
import com.sunhome.cloud.alarm.service.notify.AlarmService;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;


@Component("alarm")
public class AlarmForward implements ApplicationListener<AlarmEvent>, ApplicationContextAware {

    Map<String, AlarmService> candidates;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.candidates = applicationContext.getBeansOfType(AlarmService.class);
    }

    @Async
    @Override
    public void onApplicationEvent(AlarmEvent event) {
        List<AlarmMessage> alarmMessages = event.getAlarmMessages();
        candidates.forEach((beanName, bean) -> {
            // 告警通知
            bean.notify(alarmMessages);
        });
    }


}
