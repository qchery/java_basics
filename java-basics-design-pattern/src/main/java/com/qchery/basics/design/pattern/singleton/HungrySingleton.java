package com.qchery.basics.design.pattern.singleton;

/**
 * 单例模式之饿汉式实现
 *
 * @author Chery
 * @date 2018/3/24 15:55
 */
public class HungrySingleton {

    private static final HungrySingleton HUNGRY_SINGLETON = new HungrySingleton();

    private HungrySingleton() {
    }

    public static HungrySingleton getInstance() {
        return HUNGRY_SINGLETON;
    }

}
