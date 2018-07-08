package com.holddie.java8.tutorial.Predicate;

import java.util.Collection;
import java.util.HashSet;
import java.util.function.Predicate;

/**
 * PredicateTest
 * @author HoldDie
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/7/8 13:27
 */
public class PredicateTest {

    public static void main(String[] args) {
        HashSet<String> books = new HashSet<String>();
        books.add("三国 张飞");
        books.add("三国 赵云");
        books.add("三国 曹操");
        books.add("水浒 武松");
        books.add("西游 悟空");
        books.add("西游 八戒");

        System.out.println(callAll(books, ele -> ((String) ele).contains("三国")));

    }

    public static int callAll(Collection<String> books, Predicate predicate) {
        int total = 0;
        for (Object obj :
                books) {
            if (predicate.test(obj)) {
                total++;
            }
        }
        return total;
    }
}
