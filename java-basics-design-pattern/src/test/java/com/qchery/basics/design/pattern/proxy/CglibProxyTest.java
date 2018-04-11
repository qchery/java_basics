package com.qchery.basics.design.pattern.proxy;

import com.qchery.basics.design.pattern.proxy.cglib.SystemMgrCglibProxyFactory;
import net.sf.cglib.core.DebuggingClassWriter;

/**
 * @author Chery
 * @date 2018/4/10 20:49
 */
public class CglibProxyTest {

    public static void main(String[] args) {
        String userDir = System.getProperty("user.dir");
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, userDir);
        SystemMgrImpl proxyInstance = SystemMgrCglibProxyFactory.newProxyInstance(SystemMgrImpl.class);
        System.out.println(proxyInstance.updateUser() + " - " + proxyInstance.updateRole());
    }

}
