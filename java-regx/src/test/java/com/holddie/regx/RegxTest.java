package com.holddie.regx;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author HoldDie
 * @date 2019-05-24 16:03
 * @vsersion 1.0
 **/
public class RegxTest {

    @Test
    public void test01() {
        String str = "1990\n2009\n2017";
        // 这里应用了 (?m) 的多行匹配模式，只为方便我们测试输出
        // "^1990$|^199[1-9]$|^20[0-1][0-6]$|^2017$" 为判断 1990-2017 正确的正则表达式
        Pattern pattern = Pattern.compile("(?m)^1990$|^199[1-9]$|^200[0-9]|^201[0-6]$|^2017$");
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }

    @Test
    public void test02() {
        String str = "<img  src='aaa.jpg' /><img src=bbb.png/><img src=\"ccc.png\"/>" +
                "<img src='ddd.exe'/><img src='eee.jpn'/>";
        // 这里我们考虑了一些不规范的 img 标签写法，比如：空格、引号
        Pattern pattern = Pattern.compile("<img\\s+src=(?:['\"])?(?<src>\\w+.(jpg|png))(?:['\"])?\\s*/>");
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()) {
            System.out.println(matcher.group("src"));
        }
    }

    @Test
    public void test04(){
        // 去除单词与 , 和 . 之间的空格
        String Str = "Hello , World .";
        String pattern = "(\\w)(\\s+)([.,])";
        // $0 匹配 `(\w)(\s+)([.,])` 结果为 `o空格,` 和 `d空格.`
        // $1 匹配 `(\w)` 结果为 `o` 和 `d`
        // $2 匹配 `(\s+)` 结果为 `空格` 和 `空格`
        // $3 匹配 `([.,])` 结果为 `,` 和 `.`
        System.out.println(Str.replaceAll(pattern, "$1$3")); // Hello, World.
    }

    @Test
    public void test05(){
        String str = "img.jpg";
        // 分组且创建反向引用
        Pattern pattern = Pattern.compile("(jpg|png)");
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()) {
            System.out.println(matcher.group());
            System.out.println(matcher.group(1));
        }
    }

    @Test
    public void test06(){
        String str = "img.jpg";
        // 分组但不创建反向引用
        Pattern pattern = Pattern.compile("(?:jpg|png)");
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()) {
            System.out.println(matcher.group());
            // wrong 无反向引用
            System.out.println(matcher.group(1));
        }
    }

    @Test
    public void test07(){
        String str = "@wxj 你好啊";
        Pattern pattern = Pattern.compile("@(?<first>\\w+\\s)"); // 保存一个副本
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()) {
            System.out.println(matcher.group(0));
            System.out.println(matcher.group(1));
            System.out.println(matcher.group("first"));
        }
    }

    @Test
    public void test08(){
        System.out.println("wxj".matches("wxj"));
        System.out.println("----------");

        String[] array = "w x j".split("\\s");
        for (String item : array) {
            System.out.println(item);
        }
        System.out.println("----------");

        System.out.println("w x j".replaceFirst("\\s", "-"));
        System.out.println("----------");

        System.out.println("w x j".replaceAll("\\s", "-"));
    }

    @Test
    public void test09(){
        String text = "Hello Regex!";

        Pattern pattern = Pattern.compile("\\w+");
        // Java 中忽略大小写，有两种写法：
        // Pattern pattern = Pattern.compile("\\w+", Pattern.CASE_INSENSITIVE);
        // Pattern pattern = Pattern.compile("(?i)\\w+"); // 推荐写法
        Matcher matcher = pattern.matcher(text);
        // 遍例所有匹配的序列
        while (matcher.find()) {
            System.out.print("Start index: " + matcher.start());
            System.out.print(" End index: " + matcher.end() + " ");
            System.out.println(matcher.group());
        }
        // 创建第两个模式，将空格替换为 tab
        Pattern replace = Pattern.compile("\\s+");
        Matcher matcher2 = replace.matcher(text);
        System.out.println(matcher2.replaceAll("\t"));
    }

    @Test
    public void test10(){
        String str = "22人到人间";
        Pattern pattern = Pattern.compile("[\\u4e00-\\u9fa5]+");
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }

    @Test
    public void test11(){
        String str = "<div>文章标题</div><div>发布时间</div>";
        // 贪婪模式
        Pattern pattern = Pattern.compile("<div>(?<title>.+)</div>");
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()) {
            System.out.println(matcher.group("title"));
        }

        System.out.println("--------------");

        // 非贪婪模式
        pattern = Pattern.compile("<div>(?<title>.+?)</div>");
        matcher = pattern.matcher(str);
        while (matcher.find()) {
            System.out.println(matcher.group("title"));
        }
    }



}
