package com.holddie.java.base;

/**
 * @author yangze1
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/4/3 7:34
 */
public class TestClass {
    //    private void testMethod(){
//        System.out.println("testMethod");
//    }
    public static void main(String[] args) {

//        Math.toRadians(42);
//        ((TestClass)null).testMethod();

        double i = 3;
        int i1 =1;
        Integer var1 = new Integer(1);
        Integer var2 = var1;
        doSomething(var2);
        System.out.print(var1.intValue());
        System.out.print(var1 == var2);
    }

    public float func4() {
        double i = 4;
        return (float) i;
    }
    private static void doSomething(Integer var2) {
        var2.toString();
    }
}
