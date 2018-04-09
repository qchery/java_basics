package com.qchery.basics.design.pattern.proxy;

import com.qchery.basics.design.pattern.proxy.cglib.SystemMgrCglibProxyFactory;
import com.qchery.basics.design.pattern.proxy.jdk.SystemMgrJdkProxyFactory;
import com.qchery.basics.design.pattern.proxy.stc.StaticSystemMgrProxy;
import org.junit.Test;

/**
 * @author Chery
 * @date 2018/4/1 20:24
 */
public class ProxyTest {

    @Test
    public void testStaticProxy() {
        StaticSystemMgrProxy staticProxy = new StaticSystemMgrProxy(new SystemMgrImpl());
        System.out.println(staticProxy.updateUser() + " - " + staticProxy.updateRole());
    }

    public static void main(String[] args) {
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        SystemMgr proxyInstance = SystemMgrJdkProxyFactory.getProxyInstance(new SystemMgrImpl());
        System.out.println(proxyInstance.updateUser() + " - " + proxyInstance.updateRole());
    }

    @Test
    public void testCglibProxy() {
        SystemMgrImpl proxyInstance = SystemMgrCglibProxyFactory.newProxyInstance(SystemMgrImpl.class);
        System.out.println(proxyInstance.updateUser() + " - " + proxyInstance.updateRole());
    }

}
