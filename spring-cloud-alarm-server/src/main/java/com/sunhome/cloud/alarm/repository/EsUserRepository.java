package com.sunhome.cloud.alarm.repository;

import com.sunhome.cloud.alarm.entiy.User;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @author wangqijia
 * @date 2019/12/5 14:05
 */
public interface EsUserRepository extends ElasticsearchRepository<User, Integer> {

}
