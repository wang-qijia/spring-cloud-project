package com.sunhome.cloud.alarm.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author wangqijia
 * @date 2019/11/29 13:28
 */

@Component
@ConfigurationProperties(prefix = "alarm.mail")
public class AlarmProperties {
    private String from;
    private String to;
    private String subject;

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
