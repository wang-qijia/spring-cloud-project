# Spring Cloud Skywalking

## 分布式调用链跟踪工具

# 下载地址
http://skywalking.apache.org/downloads/

## 客户端接入方式
* 代理程序agent放入易于管理的位置
* 将-javaagent：/path/to/skywalking-agent/skywalking-agent.jar添加到VM参数

[agent-config](https://github.com/apache/skywalking/blob/master/docs/en/setup/service-agent/java-agent/README.md#table-of-agent-configuration-properties)
## 告警原理
```java
// 全包名路径
org.apache.skywalking.oap.server.core.alarm.provider.RunningRule

 public AlarmMessage checkAlarm() {
            if (isMatch()) {
                /**
                 * When
                 * 1. Metrics value threshold triggers alarm by rule
                 * 2. Counter reaches the count threshold;
                 * 3. Isn't in silence stage, judged by SilenceCountdown(!=0).
                 */
                counter++;
                if (counter >= countThreshold && silenceCountdown < 1) {
                    silenceCountdown = silencePeriod;

                    // set empty message, but new message
                    AlarmMessage message = new AlarmMessage();
                    return message;
                } else {
                    silenceCountdown--;
                }
            } else {
                silenceCountdown--;
                if (counter > 0) {
                    counter--;
                }
            }
            return AlarmMessage.NONE;
        }
        private boolean isMatch() {
                    int matchCount = 0;
                    for (Metrics metrics : values) {
                        if (metrics == null) {
                            continue;
                        }
        
                        switch (valueType) {
                            case LONG:
                                long lvalue = ((LongValueHolder)metrics).getValue();
                                long lexpected = RunningRule.this.threshold.getLongThreshold();
                                switch (op) {
                                    case GREATER:
                                        if (lvalue > lexpected)
                                            matchCount++;
                                        break;
                                    case LESS:
                                        if (lvalue < lexpected)
                                            matchCount++;
                                        break;
                                    case EQUAL:
                                        if (lvalue == lexpected)
                                            matchCount++;
                                        break;
                                }
                                break;
                            case INT:
                                int ivalue = ((IntValueHolder)metrics).getValue();
                                int iexpected = RunningRule.this.threshold.getIntThreshold();
                                switch (op) {
                                    case LESS:
                                        if (ivalue < iexpected)
                                            matchCount++;
                                        break;
                                    case GREATER:
                                        if (ivalue > iexpected)
                                            matchCount++;
                                        break;
                                    case EQUAL:
                                        if (ivalue == iexpected)
                                            matchCount++;
                                        break;
                                }
                                break;
                            case DOUBLE:
                                double dvalue = ((DoubleValueHolder)metrics).getValue();
                                double dexpected = RunningRule.this.threshold.getDoubleThreadhold();
                                switch (op) {
                                    case EQUAL:
                                        // NOTICE: double equal is not reliable in Java,
                                        // match result is not predictable
                                        if (dvalue == dexpected)
                                            matchCount++;
                                        break;
                                    case GREATER:
                                        if (dvalue > dexpected)
                                            matchCount++;
                                        break;
                                    case LESS:
                                        if (dvalue < dexpected)
                                            matchCount++;
                                        break;
                                }
                                break;
                        }
                    }
        
                    // Reach the threshold in current bucket.
                    return matchCount >= countThreshold;
                }
```

## 参考官方demo
[演示地址](http://122.112.182.72:8080/)

[github_spring-cloud-example](https://github.com/SkyAPMTest/spring-cloud-example)

可参考
[告警文章](https://blog.csdn.net/zhllansezhilian/article/details/88304332)









