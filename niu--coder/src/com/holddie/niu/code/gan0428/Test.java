package com.holddie.niu.code.gan0428;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yangze1
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/4/28 8:28
 */
public class Test {
    public static void main(String[] args) {
        List<Integer> NumberList =new ArrayList<Integer>();
        NumberList.add(2);
        NumberList.add(4);
        NumberList.add(1);
        NumberList.add(3);
        NumberList.add(5);
        for(int i =0;i<NumberList.size();++i)
        {
            int v = NumberList.get(i);
            if(v%2==0)
            {
                NumberList.remove(v);
            }
        }
        System.out.println(NumberList);
    }
}
