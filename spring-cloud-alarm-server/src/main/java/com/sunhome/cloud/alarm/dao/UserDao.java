package com.sunhome.cloud.alarm.dao;

import com.sunhome.cloud.alarm.entiy.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @author wangqijia
 * @date 2019/12/5 14:19
 */
@Repository
public class UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<User> getAll() {
        String sql = "select id,name from user";
        return jdbcTemplate.query(sql, new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet resultSet, int i) throws SQLException {
                User user = new User();
                user.setId(resultSet.getInt(1));
                user.setName(resultSet.getString(2));
                return user;
            }
        });
    }
}
