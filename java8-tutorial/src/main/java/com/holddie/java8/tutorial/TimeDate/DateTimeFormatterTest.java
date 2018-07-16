package com.holddie.java8.tutorial.TimeDate;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 格式化日期时间
 * @author HoldDie
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/7/16 16:03
 */
public class DateTimeFormatterTest {
    public static void main(String[] args) {

        /**
         * DateTimeFormatter 提供将 format 方法将一个日期时间对象转换成格式化的字符串，
         * 但是反过来的操作却建议使用具体的日期时间类自己的 parse 方法，这样可以省去类型转换的步骤。
         */

        // 时间格式化
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm:ss");
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(formatter.format(localDateTime));

        // String --> LocalDateTime
        String str = "2018年07月16日 16:05:27";
        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm:ss");
        LocalDateTime localDateTime1 = LocalDateTime.parse(str, formatter1);
        System.out.println(localDateTime1);

    }
}
