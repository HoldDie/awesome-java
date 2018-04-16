package com.holddie.niu.code;

/**
 * @author yangze1
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/4/11 7:44
 */
public class Test0411 {
    private static String test(){
        return "2134";
    }

    public static void main(String[] args) {
        /**
         * 不可以直接使用this调用本类类方法
         */
//        String ss = this.test();
        test();
    }
}
