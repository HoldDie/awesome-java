package com.holddie.jvm.oom;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;

/**
 * VM Args: -XX:PermSize=10M -XX:MaxPermSize=10M
 * env: jdk7
 *
 * @author HoldDie
 * @version 1.0
 * @date 2020/10/21 10:09 PM
 */
public class JavaMethodAreaOOM {
	public static void main(String[] args) {
		while (true) {
			Enhancer enhancer = new Enhancer();
			enhancer.setSuperclass(OOMObject.class);
			enhancer.setUseCache(false);
			enhancer.setCallback((MethodInterceptor) (o, method, objects, methodProxy) -> methodProxy.invoke(objects, args));
			enhancer.create();
		}
	}

	static class OOMObject {

	}
}
