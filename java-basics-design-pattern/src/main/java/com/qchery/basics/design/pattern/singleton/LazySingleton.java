package com.qchery.basics.design.pattern.singleton;

/**
 * 单例模式之懒汉式实现
 *
 * @author Chery
 * @date 2018/3/24 16:03
 */
public class LazySingleton {

    private static LazySingleton lazySingleton;

    private LazySingleton() {
    }

    public static LazySingleton getInstance() {
        if (lazySingleton == null) {
            synchronized (LazySingleton.class) {
                if (lazySingleton == null) {
                    lazySingleton = new LazySingleton();
                }
            }
        }
        return lazySingleton;
    }

}
