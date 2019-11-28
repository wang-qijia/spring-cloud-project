package com.sunhome.cloud.alarm.service.notify;

import com.sunhome.cloud.alarm.entiy.AlarmMessageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.context.IContext;

import java.util.List;

/**
 * @author wangqijia
 * @date 2019/11/28 17:20
 */
@Component
public class MailContentBuilder {
    @Autowired
    private TemplateEngine templateEngine;


    public String build(List<AlarmMessageDTO> alarmMessageList) {
        Context context = new Context();
        context.setVariable("alarmList", alarmMessageList);
        return templateEngine.process("alarmNotify", context);
    }

}