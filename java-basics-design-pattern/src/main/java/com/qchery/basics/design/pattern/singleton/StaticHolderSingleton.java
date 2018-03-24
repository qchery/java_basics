package com.qchery.basics.design.pattern.singleton;

/**
 * 单例模式之静态类持有实现，可预防反射攻击
 *
 * @author Chery
 * @date 2018/3/24 16:22
 */
public class StaticHolderSingleton {

    private StaticHolderSingleton() {
    }

    private static class InstanceHolder {
        private static final StaticHolderSingleton INSTANCE = new StaticHolderSingleton();
    }

    public static StaticHolderSingleton getInstance() {
        return InstanceHolder.INSTANCE;
    }

}
