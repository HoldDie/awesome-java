package com.holddie.regx;


import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author HoldDie
 * @date 2019-05-24 15:17
 * @vsersion 1.0
 **/
public class RegxBaseTest {


    @Test
    public void test01() {
        Pattern p = Pattern.compile("\\w+");
        System.out.println(p.pattern());
    }

    @Test
    public void test02() {
        Pattern p = Pattern.compile("\\d+");
        String[] str = p.split("我的QQ是:456456我的电话是:0532214我的邮箱是:aaa@aaa.com");
        System.out.printf(String.valueOf(str.length));
        System.out.println(str[0]);
    }

    @Test
    public void test03() {
        Pattern p = Pattern.compile("\\d+");
        Matcher m = p.matcher("2223bb");
        System.out.println(m.matches());   //匹配整个字符串
        if (m.matches()) {
            m.start();   //返回0,原因相信大家也清楚了
            m.end();   //返回6,原因相信大家也清楚了,因为matches()需要匹配所有字符串
            m.group();   //返回2223bb
        }
    }

    @Test
    public void test04() {
        Pattern p = Pattern.compile("([a-z]+)(\\d+)");
        Matcher m = p.matcher("aaa2223bb");
        System.out.println(m.find());   //匹配aaa2223
        System.out.println(m.groupCount());   //返回2,因为有2组
        System.out.println(m.start(1));   //返回0 返回第一组匹配到的子字符串在字符串中的索引号
        System.out.println(m.start(2));   //返回3
        System.out.println(m.end(1));   //返回3 返回第一组匹配到的子字符串的最后一个字符在字符串中的索引位置.
        System.out.println(m.end(2));   //返回7
        System.out.println(m.group(1));   //返回aaa,返回第一组匹配到的子字符串
        System.out.println(m.group(2));   //返回2223,返回第二组匹配到的子字符串
    }

    @Test
    public void test05() {
        Pattern p = Pattern.compile("\\d+");
        Matcher m = p.matcher("我的QQ是:456456 我的电话是:0532214 我的邮箱是:aaa123@aaa.com");
        while (m.find()) {
            System.out.println(m.group());
            System.out.print("start:" + m.start());
            System.out.println(" end:" + m.end());
        }
    }

}
