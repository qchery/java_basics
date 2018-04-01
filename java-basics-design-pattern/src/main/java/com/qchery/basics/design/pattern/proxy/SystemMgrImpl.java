package com.qchery.basics.design.pattern.proxy;

/**
 * @author Chery
 * @date 2018/4/1 20:11
 */
public class SystemMgrImpl implements SystemMgr {

    @Override
    public String updateUser() {
        System.out.println("更新用户信息...");
        return "张三";
    }

    @Override
    public String updateRole() {
        System.out.println("更新角色信息...");
        return "管理员";
    }

}
