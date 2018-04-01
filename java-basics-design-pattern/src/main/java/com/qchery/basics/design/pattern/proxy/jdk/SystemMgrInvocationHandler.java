package com.qchery.basics.design.pattern.proxy.jdk;

import com.qchery.basics.design.pattern.proxy.SystemMgr;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author Chery
 * @date 2018/4/1 20:28
 */
public class SystemMgrInvocationHandler implements InvocationHandler {

    private SystemMgr systemMgr;

    public SystemMgrInvocationHandler(SystemMgr systemMgr) {
        this.systemMgr = systemMgr;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(SystemMgrInvocationHandler.class.getSimpleName() + " 拦截方法：" + method.getName());
        return method.invoke(systemMgr, args);
    }
}
