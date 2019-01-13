package com.erp.pojo;

/**
 * Created by zgq7 on 2019/1/13 0013.
 * 存放权限的bean
 */
public class Permission {
    private Integer id;
    private Integer role_id;
    //权限
    private String perms;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRole_id() {
        return role_id;
    }

    public void setRole_id(Integer role_id) {
        this.role_id = role_id;
    }

    public String getPerms() {
        return perms;
    }

    public void setPerms(String perms) {
        this.perms = perms;
    }

    @Override
    public String toString() {
        return "Permission{" + "perms='" + perms + "}";
    }
}
