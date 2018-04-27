package com.holddie.module;

import java.net.URL;
import java.net.URLClassLoader;

public class ModuleClassLoader extends URLClassLoader {

    private ModuleManager manager = new ModuleManager();

    public ModuleClassLoader(URL[] urls, ModuleManager manager) {
        super(urls);
        this.manager = manager;
    }

    protected Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {

        if (manager.getCache().containsKey(name)) {
            return manager.getCache().get(name);
        } else {
            return super.loadClass(name, resolve);
        }
    }
}