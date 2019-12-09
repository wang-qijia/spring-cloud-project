package com.sunhome.cloud.alarm.controller;

import java.util.Arrays;

/**
 * @author wangqijia
 * @date 2019/12/9 16:30
 */
public class Test {
    private static final String[] FILTER_EXCEPTION = {"com.sunhome.cloud.alarm.exception.ServiceException"};

    public static void main(String[] args) {
        if (Arrays.asList(FILTER_EXCEPTION).contains("com.sunhome.cloud.alarm.exception.")) {
            System.out.println("su");
        }else{
            System.out.println("err");        }

    }
}
