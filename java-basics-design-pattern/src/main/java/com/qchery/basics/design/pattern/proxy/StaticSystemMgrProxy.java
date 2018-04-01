package com.qchery.basics.design.pattern.proxy;

/**
 * @author Chery
 * @date 2018/4/1 20:13
 */
public class StaticSystemMgrProxy implements SystemMgr {

    private SystemMgr systemMgr;

    public StaticSystemMgrProxy(SystemMgr systemMgr) {
        this.systemMgr = systemMgr;
    }

    @Override
    public String getUser() {
        System.out.println(this.getClass().getSimpleName() + ".getUser()");
        return systemMgr.getUser();
    }

    @Override
    public String getRole() {
        System.out.println(this.getClass().getSimpleName() + ".getRole()");
        return systemMgr.getRole();
    }
}
