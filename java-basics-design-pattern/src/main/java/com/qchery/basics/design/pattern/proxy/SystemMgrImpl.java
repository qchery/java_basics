package com.qchery.basics.design.pattern.proxy;

/**
 * @author Chery
 * @date 2018/4/1 20:11
 */
public class SystemMgrImpl implements SystemMgr {

    @Override
    public String getUser() {
        return "张三";
    }

    @Override
    public String getRole() {
        return "管理员";
    }

}
