package com.holddie.niu.code.gan1804.gan0426;

import java.sql.Driver;
import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * @author yangze1
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/4/26 8:31
 */
public class MysqlTest {

    public static void main(String[] args) {
//        Thread.currentThread().setContextClassLoader(MysqlTest.class.getClassLoader().getParent());
        //(1)
        ServiceLoader<Driver> loader = ServiceLoader.load(Driver.class);
        //(2)
        Iterator<Driver> iterator = loader.iterator();
        while (iterator.hasNext()) {
            Driver driver = (Driver) iterator.next();
            System.out.println("driver:" + driver.getClass() + ",loader:" + driver.getClass().getClassLoader());
        }
        //(3)
        System.out.println("current thread contextloader:" + Thread.currentThread().getContextClassLoader());
        //(4)
        System.out.println("ServiceLoader loader:" + ServiceLoader.class.getClassLoader());
    }
}
