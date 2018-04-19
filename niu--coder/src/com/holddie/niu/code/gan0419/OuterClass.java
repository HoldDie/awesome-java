package com.holddie.niu.code.gan0419;

public class OuterClass{
    private float f=1.0f;
    //插入代码到这里

    // 内部类不能使用静态方法
//    class InnerClass{
//        public static float func(){return f;}
//    }

//    抽象方法不能有方法体
//    abstract class InnerClass{
//        public abstract float func(){}
//    }


    // 静态方法不能调用非静态变量
//    static class InnerClass{
//        protected static float func(){return f;}
//    }

    // 内部类不行使用static方法
//    public class InnerClass{
//        static float func(){return f;}
//    }

}