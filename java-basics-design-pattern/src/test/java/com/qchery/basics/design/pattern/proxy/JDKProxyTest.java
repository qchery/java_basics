package com.qchery.basics.design.pattern.proxy;

import com.qchery.basics.design.pattern.proxy.jdk.SystemMgrJdkProxyFactory;

/**
 * @author Chery
 * @date 2018/4/11 23:08
 */
public class JDKProxyTest {

    public static void main(String[] args) {
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        SystemMgr proxyInstance = SystemMgrJdkProxyFactory.getProxyInstance(new SystemMgrImpl());
        System.out.println(proxyInstance.updateUser() + " - " + proxyInstance.updateRole());
    }

}
