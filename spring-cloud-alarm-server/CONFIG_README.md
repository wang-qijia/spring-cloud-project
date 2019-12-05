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
          period: 5
```


参考文档
https://github.com/apache/skywalking/blob/master/docs/en/setup/backend/dynamic-config.md

