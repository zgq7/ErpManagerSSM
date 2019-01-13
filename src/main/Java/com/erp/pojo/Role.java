package com.erp.pojo;

/**
 * Created by zgq7 on 2019/1/13 0013.
 * 存放权限的bean
 * */
public class Role {
    private Integer id;
    private String roleName;
    private Integer user_id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return "角色：role-->["+roleName+"]";
    }
}
