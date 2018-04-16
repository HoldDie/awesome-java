package com.holddie.niu.code;

/**
 * @author yangze1
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/4/12 7:18
 */
public class Test0412 {
    public static void main(String args[])
    {
        String str=new String("hello");
        // String 两者的区别
        //        if(str=="hello")  false
//        if(str.equals("hello")) // true
//        {
//            System.out.println("true");
//        }
//        else     {
//            System.out.println("false");
//        }
//        System.out.println(Math.floor(-8.5));

        String  s = null;
//        if((s==null)|(s.length()>0)){
        if((s!=null)&(s.length()>0)){
            System.out.println(123);
        }
    }

    float fun3(){
        long i = 3;
        return i;
    }
}
