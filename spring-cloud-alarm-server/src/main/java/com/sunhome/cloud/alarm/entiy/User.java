package com.sunhome.cloud.alarm.entiy;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 * @author wangqijia
 * @date 2019/11/28 20:51
 */
@Document(indexName = "sw", type = "test",shards = 1,replicas = 0)
public class User {
    @Id
    private int id;

    @Field(type = FieldType.Text)
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
