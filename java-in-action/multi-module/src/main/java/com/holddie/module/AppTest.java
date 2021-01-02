package com.holddie.module;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author yangze1
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/4/27 22:06
 */
public class AppTest {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException {

        System.out.println("Hello World!");
        ModuleManager manager = new ModuleManager();
        List<String> jarList = new ArrayList<String>();
        jarList.add(
                "D:\\workspace\\common-tutorial\\multi-module\\multi-moduleA\\target\\multi-moduleA-1.0-SNAPSHOT.jar");
        jarList.add(
                "D:\\workspace\\common-tutorial\\multi-module\\multi-moduleB\\target\\multi-moduleB-1.0-SNAPSHOT.jar");
        manager.setMoudleList(jarList);
        manager.init();

        ModuleClassLoader classLoader = new ModuleClassLoader(((URLClassLoader) AppTest.class.getClassLoader()).getURLs(), manager);

        Class serviceA = classLoader.loadClass("com.holddie.multi.modulea.MoudleServiceA");
        Method sayHelloServiceA = serviceA.getMethod("sayHelloServiceA");
        String result = (String) sayHelloServiceA.invoke(serviceA.newInstance(), null);
        System.out.println(result);
    }
}
