package com.sunhome.cloud.alarm.service.simulat;

import com.sunhome.cloud.alarm.dao.UserDao;
import com.sunhome.cloud.alarm.entiy.User;
import org.apache.skywalking.apm.toolkit.trace.ActiveSpan;
import org.apache.skywalking.apm.toolkit.trace.Trace;
import org.apache.skywalking.apm.toolkit.trace.TraceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
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
    private UserDao userDao;

    /**
     * 此方法加到调用链中
     *
     * @return
     */
    @Trace(operationName = "queryUser")
    public List<User> query() {

        return userDao.getAll();
    }
}
