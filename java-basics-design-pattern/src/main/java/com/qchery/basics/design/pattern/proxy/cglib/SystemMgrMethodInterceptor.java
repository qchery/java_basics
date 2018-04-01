package com.qchery.basics.design.pattern.proxy.cglib;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author Chery
 * @date 2018/4/1 20:41
 */
public class SystemMgrMethodInterceptor implements MethodInterceptor {
    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        System.out.println(SystemMgrMethodInterceptor.class.getSimpleName() + " 拦截方法：" + method.getName());
        return proxy.invokeSuper(obj, args);
    }
}
