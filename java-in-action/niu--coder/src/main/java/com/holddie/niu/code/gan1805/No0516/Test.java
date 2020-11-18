package com.holddie.niu.code.gan1805.No0516;

/**
 * @author yangze1
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/5/16 9:36
 */
public class Test {
    int[] a = new int[1000];
    int[] c = new int[100000];
    int[] b = new int[100];


    void pa() {
        for (int aB : b) {
            for (int j = 0; j < a.length; j++) {
                ++c[j];
            }
        }
    }

    void pb() {
        int i, j;
        for (i = 0; i < a.length; ++i)
            for (j = 0; j < b.length; ++j)
                ++c[j];
    }

    public static void main(String[] args) {
        Test test = new Test();
        long time1 = System.currentTimeMillis();
        test.pa();
        System.out.println(System.currentTimeMillis()-time1);

        long time2 = System.currentTimeMillis();
        test.pb();
        System.out.println(System.currentTimeMillis()-time2);
    }
}
