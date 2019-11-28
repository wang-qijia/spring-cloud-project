/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package com.sunhome.cloud.alarm.entiy;

/**
 * 详细见
 * https://github.com/apache/skywalking/blob/master/docs/en/setup/backend/backend-alarm.md#rules
 * 源码见RunningRule->142行
 */
public class AlarmMessageDTO {

    /**
     * 范围名称->作用域
     */
    private String scope;
    /**
     * 目标范围实体名称
     */
    private String name;
    /**
     * 规则名_Rule后缀的
     */
    private String ruleName;
    /**
     * 告警消息->alarm-settings.yml见配置文件
     */
    private String alarmMessage;
    /**
     * 发送告警服务端当前时间
     */
    private String startTime;

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRuleName() {
        return ruleName;
    }

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }

    public String getAlarmMessage() {
        return alarmMessage;
    }

    public void setAlarmMessage(String alarmMessage) {
        this.alarmMessage = alarmMessage;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }
}
