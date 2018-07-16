package com.holddie.java8.tutorial.TimeDate;

import java.time.LocalTime;

/**
 * 处理时间过程
 * @author HoldDie
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/7/16 15:04
 */
public class LocalTimeTest {

    public static void main(String[] args) {
        // 15:26:28.879
        LocalTime localTime = LocalTime.now();
        System.out.println(localTime);

        // 23:59:34
        LocalTime localTime1 = LocalTime.of(23, 59, 34);
        System.out.println(localTime1);

        // 00:16:40
        LocalTime localTime2 = LocalTime.ofSecondOfDay(1000);
        System.out.println(localTime2);

        // 23:59:59.999999999
        LocalTime localTime3 = LocalTime.MAX;
        System.out.println(localTime3);

        /**
         *public int getHour()
         * public int getMinute()
         * public int getSecond()
         * public int getNano()
         * public LocalTime withHour(int hour)：修改当前 LocalTime 实例中的 hour 属性并重新返回一个新的实例
         * public LocalTime withMinute(int minute)：类似
         * public LocalTime withSecond(int second)：秒
         */
    }
}
