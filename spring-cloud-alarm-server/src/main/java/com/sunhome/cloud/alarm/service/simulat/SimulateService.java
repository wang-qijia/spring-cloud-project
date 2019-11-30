package com.sunhome.cloud.alarm.service.simulat;

import com.sunhome.cloud.alarm.entiy.User;
import org.apache.skywalking.apm.toolkit.trace.ActiveSpan;
import org.apache.skywalking.apm.toolkit.trace.Trace;
import org.apache.skywalking.apm.toolkit.trace.TraceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @author wangqijia
 * @date 2019/11/28 20:39
 */
@Service
public class SimulateService {

    @Autowired
    JdbcTemplate jdbcTemplate;

    /**
     * 此方法加到调用链中
     *
     * @return
     */
    @Trace(operationName = "queryUser")
    public User query() {
        String sql = "select id,name from user limit 1";
        User user = jdbcTemplate.queryForObject(sql, new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet resultSet, int i) throws SQLException {
                User user = new User();
                user.setId(resultSet.getInt(1));
                user.setName(resultSet.getString(2));
                return user;
            }
        });
        return user;
    }
}
