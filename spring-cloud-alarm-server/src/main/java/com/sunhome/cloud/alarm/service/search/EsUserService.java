package com.sunhome.cloud.alarm.service.search;

import com.sunhome.cloud.alarm.dao.UserDao;
import com.sunhome.cloud.alarm.entiy.User;
import com.sunhome.cloud.alarm.repository.EsUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.data.elasticsearch.ElasticsearchAutoConfiguration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author wangqijia
 * @date 2019/12/5 14:08
 */
@Service
public class EsUserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private EsUserRepository userRepository;

    public int importAll() {
        List<User> userList = userDao.getAll();
        Iterable<User> esProductIterable = userRepository.saveAll(userList);
        Iterator<User> iterator = esProductIterable.iterator();
        int result = 0;
        while (iterator.hasNext()) {
            result++;
            iterator.next();
        }
        return result;
    }

    public List<User> getAll() {
        Iterable<User> iterable = userRepository.findAll();
        List<User> users = new ArrayList<>();
        while (iterable.iterator().hasNext()) {
            User user = new User();
            user.setId(iterable.iterator().next().getId());
            user.setName(iterable.iterator().next().getName());
            users.add(user);

        }
        return users;
    }
}
