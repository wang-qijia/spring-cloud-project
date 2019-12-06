# Spring Cloud Skywalking 动态配置指南



## 动态配置(apollo)
```yaml
    configuration:
      none:
        apollo:
          apolloMeta: http://ip:9089
          apolloCluster: default
          apolloEnv: dev
          appId: skywalking-oap
          period: 5 #时间间隔
```
直接把alarm-settings.yml内容复制到value属性上
![配置指南](doc/image/oap_apollo_config.jpg)


参考文档
源码见 [AlarmRulesWatcher]

https://github.com/apache/skywalking/blob/master/docs/en/setup/backend/dynamic-config.md

