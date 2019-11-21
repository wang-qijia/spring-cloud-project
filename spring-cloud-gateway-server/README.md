# Spring Cloud Gateway


## 配置方式
yml声明配置,可以选择编程时配置

## 常见问题
1. spring gateway 官方网站介绍的很少,详细使用时尤其用在生产上时多看源码
2. 采用netty作为项目容器, 网关已集成ribbon框架,详细参考 GatewayLoadBalancerClientAutoConfiguration
3. gateway和zuul配置不同,配置时请注意


## 配置指南
* NettyRoutingFilter 转发后端服务请求过滤器，可以参考此过滤器
* HttpClientProperties 配置httpClient 超时配置类

