package com.sunhome.cloud.alarm.controller;

import com.sunhome.cloud.alarm.entiy.User;
import com.sunhome.cloud.alarm.service.search.EsUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author wangqijia
 * @date 2019/12/5 14:38
 */
@RestController
@Api(tags = "EsUserController", description = "用户管理")
@RequestMapping("/esProduct")
public class EsUserController {

    @Autowired
    private EsUserService esUserService;

    @ApiOperation(value = "导入所有数据库中商品到ES")
    @RequestMapping(value = "/importAll", method = RequestMethod.POST)
    public Integer importAllList() {
        int count = esUserService.importAll();
        return count;
    }

    @ApiOperation(value = "导入所有数据库中商品到ES")
    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public List<User> getAll() {
        List<User> userList = esUserService.getAll();
        return userList;
    }
}
