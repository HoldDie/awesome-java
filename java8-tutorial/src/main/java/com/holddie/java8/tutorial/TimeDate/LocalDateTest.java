package com.holddie.java8.tutorial.TimeDate;

import java.time.LocalDate;

/**
 * LocalDate测试
 * @author HoldDie
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/7/16 11:14
 */
public class LocalDateTest {

    public static void main(String[] args) {

        // 构建LocalDate 实例
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);
        System.out.println(localDate.getChronology());
        System.out.println(localDate.getDayOfYear());
        System.out.println(localDate.getDayOfMonth());
        System.out.println(localDate.getDayOfWeek());

        // 自定义格式时间
        LocalDate localDate1 = LocalDate.of(2018, 7, 15);
        System.out.println(localDate1);

        // 某年的多少天
        LocalDate localDate2 = LocalDate.ofYearDay(2018, 100);
        System.out.println(localDate2);

        // 截止1970年的偏差
        LocalDate localDate3 = LocalDate.ofEpochDay(10);
        System.out.println(localDate3);

        /**
         * public int getYear()：获取年份信息
         * public int getMonthValue()：获取月份信息
         * public int getDayOfMonth()：获取当前日是这个月的第几天
         * public int getDayOfYear()：获取当前日是这一年的第几天
         * public boolean isLeapYear()：是否是闰年
         * public int lengthOfYear()：获取这一年有多少天
         * public DayOfWeek getDayOfWeek()：返回星期信息
         */




    }
}
