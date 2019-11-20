package com.sunhome.cloud.client.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author wangqijia
 * @date 2019/11/20 15:43
 */
@ConfigurationProperties(prefix = "sunhome.client")
public class ClientProperties {
    private String name;

    private String url;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
