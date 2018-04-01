package com.qchery.basics.design.pattern.proxy.jdk;

import com.qchery.basics.design.pattern.proxy.SystemMgr;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author Chery
 * @date 2018/4/1 20:28
 */
public class SystemMgrJdkProxyFactory {

    public static SystemMgr getProxyInstance(SystemMgr instance) {
        return (SystemMgr) Proxy.newProxyInstance(SystemMgr.class.getClassLoader(),
                new Class[]{SystemMgr.class}, new SystemMgrTxnInvocationHandler(instance));
    }

    private static class SystemMgrTxnInvocationHandler implements InvocationHandler {

        private SystemMgr instance;

        private SystemMgrTxnInvocationHandler(SystemMgr instance) {
            this.instance = instance;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("开始事务...");
            Object invoke;
            try {
                invoke = method.invoke(instance, args);
                System.out.println("提交事务...");
            } catch (Exception e) {
                System.out.println("回滚事务...");
                throw e;
            }
            return invoke;
        }
    }
}
