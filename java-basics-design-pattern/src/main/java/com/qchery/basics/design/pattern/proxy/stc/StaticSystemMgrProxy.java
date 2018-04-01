package com.qchery.basics.design.pattern.proxy.stc;

import com.qchery.basics.design.pattern.proxy.SystemMgr;

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
    public String updateUser() {
        System.out.println("开始事务...");
        String user;
        try {
            user = systemMgr.updateUser();
            System.out.println("提交事务...");
        } catch (Exception e) {
            System.out.println("回滚事务...");
            throw e;
        }
        return user;
    }

    @Override
    public String updateRole() {
        System.out.println("开始事务...");
        String role;
        try {
            role = systemMgr.updateRole();
            System.out.println("提交事务...");
        } catch (Exception e) {
            System.out.println("回滚事务...");
            throw e;
        }
        return role;
    }
}
