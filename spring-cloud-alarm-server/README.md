# Spring Cloud Skywalking 

## 无侵入调用链埋点框架

## Download...
先跑起来,后了解原理，然后业务上不满足时在进行插件开发

## 辅助工具
postman串行设置请求数,达到模拟效果(工具随便选择)

## 回调地址
    webhooks:
      - http://127.0.0.1:8099/alarm/notify

## 告警配置
1. 时间窗口为5分钟,在连续的两分钟内计数两个时触发警报, silence-period静默周期为0，接下来时间内一旦满足条件一直发送告警
如果 silence-period = threshold,会跳过该时间内
```yaml
  service_resp_time_rule:
    metrics-name: service_resp_time
    op: ">"
    threshold: 2000
    period: 5
    count: 2
    silence-period: 0
    message: The average service response event in the last 2 minutes is greater than 2 seconds
```
http://127.0.0.1:8099/simulate/readTimeout/
![服务告警页面图片](image/alarm_img_one_page.jpg)

![服务告警邮箱图片](image/alarm_img_one_mail.jpg)


## 演示配置








