package com.sunhome.cloud.stream.common;

/**
 * @author wangqijia
 * @date 2019/12/24 13:48
 */
public class MqMessage {
    private String name;
    private int type;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
