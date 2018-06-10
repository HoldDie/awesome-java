package com.holddie.niu.code.gan1804;

import java.util.List;

/**
 * @author HoldDie
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/4/8 7:35
 */
public class Test0408 {

    private Integer i;
    private String j;


    private List<Integer> integers;

    private Test0408(Integer i, String j) {
        this.i = i;
        this.j = j;
    }

    private Integer getI() {
        return i;
    }

    public void setI(Integer i) {
        this.i = i;
    }

    public List<Integer> getIntegers() {
        return integers;
    }

    public void setIntegers(List<Integer> integers) {
        this.integers = integers;
    }

    public String getJ() {
        return j;
    }

    public void setJ(String j) {
        this.j = j;
    }

    public static void main(String[] args) {
//        String s;
//        System.out.println("s="+s);
//        boolean ss = false;
//        int i =0;
//        int sss = 2/i;
        Test0408 test0408 = new Test0408(0, "123");
//        Integer mm = 33;
//        System.out.println(test0408.getI().compareTo(12));
//        System.out.println(mm.compareTo(33));
//        System.out.println(mm.compareTo(12));

        for (Integer i :
                test0408.getIntegers()) {
            System.out.println(i);
        }
    }
}
