package com.sunhome.cloud.alarm.service.notify;

import java.util.Arrays;
import java.util.Optional;

/**
 * 规则匹配转换
 *
 * @author wangqijia
 * @date 2019/11/29 13:11
 */
public enum Rule {

    SERVICE_RESP_TIME_RULE("服务在过去2分钟内的平均响应时间超过2s,请查看并及时优化服务"),
    SERVICE_INSTANCE_RESP_TIME_RULE("服务实例在过去2分钟内的平均响应时间超过2s,请查看并及时优化服务"),
    ENDPOINT_AVG_RULE("端点在过去2分钟内的平均响应时间超过1s,请查看并及时优化服务"),
    SERVICE_REQ_ERROR_COUNT_RULE(" 过去2分钟内超过10个服务请求错误 "),
    SERVICE_SLA_RULE("服务在过去2分钟内的请求成功率低于90%,请查看并排错");

    private String message;

    Rule(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static String get(String ruleName, String defaultValue) {
        Optional<Rule> optionalRule = Arrays.stream(Rule.values())
                .filter(rule -> rule.name().toLowerCase().equals(ruleName))
                .findFirst();
        if (optionalRule.isPresent()) {
            return optionalRule.get().getMessage();
        }
        return defaultValue;
    }

}