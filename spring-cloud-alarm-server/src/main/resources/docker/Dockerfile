FROM java:8

VOLUME /tmp

ADD spring-cloud-alarm-server.jar spring-cloud-alarm-server.jar

EXPOSE 8099

ENTRYPOINT ["java","-jar","/spring-cloud-alarm-server.jar"]