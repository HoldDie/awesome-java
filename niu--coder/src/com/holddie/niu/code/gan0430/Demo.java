package com.holddie.niu.code.gan0430;

/**
 * @author yangze1
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/4/30 21:06
 */
public class Demo {
    public static void main(String[] args) {
//        int count = 0;
//        int num = 0;
//        for (int i=0; i<=100; i++){
//            num = num +i;
//            count = count++;
//        }
        String s1 = "abc" + "def";//1
        String s2 = new String(s1);//2
        if (s1.equals(s2))//3
            System.out.println(".equals succeeded");//4
        if (s1 == s2)//5
            System.out.println("==succeeded");//6
    }
}
