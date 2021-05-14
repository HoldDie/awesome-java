package com.holddie.jvm.oom;

/**
 * 环境：jdk1.8
 *
 * 实验一：
 * -XX:MetaspaceSize=10m -XX:MaxMetaspaceSize=10m
 *
 * 实验二
 * 使用 -XX:MaxDirectMemorySize=8m -XX:MetaspaceSize=10m -XX:MaxMetaspaceSize=10m
 * 反驳 DirectMemory 必须大于 MetaspaceSize 两者没有必然关系
 * https://www.zhihu.com/question/399007267
 */
public class MetaspaceSizeOOM {
    static javassist.ClassPool cp = javassist.ClassPool.getDefault();

    public static void main(String[] args) throws Exception {
        for (int i = 0; ; i++) {
            Class c = cp.makeClass("eu.plumbr.demo.Generated" + i).toClass();
        }
    }
}