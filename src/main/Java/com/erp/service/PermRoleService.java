package com.erp.service;

import java.util.Set;

/**
 * Created by zgq7 on 2019/1/13 0013.
 * */
public interface PermRoleService {
    /**
     * @param username 存放用户名，即卡号
     * **/
    Set<String> getRoles(String username);

    /**
     * 传入一个或者多个角色，获取全部权限**/
    Set<String> getPerms(Set<String> rightRoles);
}
