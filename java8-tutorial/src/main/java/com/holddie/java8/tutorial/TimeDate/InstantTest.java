package com.holddie.java8.tutorial.TimeDate;

import java.time.Instant;

/**
 * Instant 练习
 * @author HoldDie
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/7/16 10:25
 */
public class InstantTest {
    public static void main(String[] args) {
        // 创建 Instant 实例
        // 2018-07-16T02:28:58.576Z
        Instant instant = Instant.now();
        System.out.println(instant);

        // 通过传入一个标准时间的偏移值来构建一个Instant实例
        // 1970-01-01T00:00:20Z
        Instant instant1 = Instant.ofEpochSecond(20);
        System.out.println(instant1);

        // 2018-07-16T02:28:58.640Z
        Instant instant2 = Instant.ofEpochMilli(System.currentTimeMillis());
        System.out.println(instant2);

        // 1970-01-01T00:00:30.000000100Z
        Instant instant3 = Instant.ofEpochSecond(30, 100);
        System.out.println(instant3);

        // LocalDate 系统会有当前时刻和默认时区计算出年月日的信息


    }
}
