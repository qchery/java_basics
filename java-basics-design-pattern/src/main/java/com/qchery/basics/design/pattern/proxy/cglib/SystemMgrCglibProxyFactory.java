package com.qchery.basics.design.pattern.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author Chery
 * @date 2018/4/1 20:41
 */
public class SystemMgrCglibProxyFactory {

    private static final SystemMgrTxnMethodInterceptor SYSTEM_MGR_TXN_METHOD_INTERCEPTOR = new SystemMgrTxnMethodInterceptor();

    public static <T> T newProxyInstance(Class<T> clazz) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(SYSTEM_MGR_TXN_METHOD_INTERCEPTOR);
        return clazz.cast(enhancer.create());
    }

    private static class SystemMgrTxnMethodInterceptor implements MethodInterceptor {
        @Override
        public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
            System.out.println("开始事务...");
            Object invokeSuper;
            try {
                invokeSuper = proxy.invokeSuper(obj, args);
                System.out.println("提交事务...");
            } catch (Exception e) {
                System.out.println("回滚事务...");
                throw e;
            }
            return invokeSuper;
        }
    }

}
