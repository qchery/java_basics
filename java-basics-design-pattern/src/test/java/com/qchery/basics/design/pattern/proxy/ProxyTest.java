package com.qchery.basics.design.pattern.proxy;

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

}
