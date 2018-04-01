package com.qchery.basics.design.pattern.proxy;

import com.qchery.basics.design.pattern.proxy.cglib.SystemMgrMethodInterceptor;
import com.qchery.basics.design.pattern.proxy.jdk.SystemMgrInvocationHandler;
import net.sf.cglib.proxy.Enhancer;
import org.junit.Test;

import java.lang.reflect.Proxy;

/**
 * @author Chery
 * @date 2018/4/1 20:24
 */
public class ProxyTest {

    @Test
    public void testStaticProxy() {
        StaticSystemMgrProxy staticProxy = new StaticSystemMgrProxy(new SystemMgrImpl());
        System.out.println(staticProxy.getUser() + " - " + staticProxy.getRole());
    }

    @Test
    public void testJDKProxy() {
        SystemMgr proxyInstance = (SystemMgr) Proxy.newProxyInstance(this.getClass().getClassLoader(),
                new Class[]{SystemMgr.class}, new SystemMgrInvocationHandler(new SystemMgrImpl()));
        System.out.println(proxyInstance.getUser() + " - " + proxyInstance.getRole());
    }

    @Test
    public void testCglibProxy() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(SystemMgrImpl.class);
        enhancer.setCallback(new SystemMgrMethodInterceptor());
        SystemMgrImpl cglibProxy = (SystemMgrImpl) enhancer.create();
        System.out.println(cglibProxy.getUser() + " - " + cglibProxy.getRole());
    }

}
