package com.holddie.java8.tutorial.lambdasinaction.appd;

import java.util.function.Function;

public class Lambda {

    Function<Object, String> f = obj -> obj.toString();
}
