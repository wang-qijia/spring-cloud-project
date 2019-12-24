package com.sunhome.cloud.alarm;

import java.util.concurrent.TimeUnit;

/**
 * @author wangqijia
 * @date 2019/12/13 13:35
 */
public class Test {

    public static class bl{
        public static String str = "";

    }


    public static void main(String[] args) throws InterruptedException {
        new Thread(()->{
            Test.bl.str = "a";
        }).start();

        TimeUnit.SECONDS.sleep(2);
        new Thread(()->{
            System.out.println(   Test.bl.str);
        }).start();


    }
}
