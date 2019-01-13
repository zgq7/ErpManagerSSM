package com.erp.dao;

import com.erp.pojo.Customer;
import com.erp.pojo.Permission;
import com.erp.pojo.Role;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Set;

/**
 * Created by zgq7 on 2019/1/11.
 * 获取subject的角色和权限
 * 用户登录通过之后才能进入此接口
 * 希望---》调用存储过程
 */
public interface PermRoleDao {
    //传入用户名（先照常使用卡号），获取用户角色
    @Select("call pos_getSubjetRole(#{cardNo})")
    Set<Role> getSubjectRole(String cardNo);

    //传入用户名（先照常使用卡号），获取用户信息
    @Select("select * from erp_customer where cardNo = #{cardNo}")
    Customer getCustomerInfo(String cardNo) throws Exception;

    //传入角色名得到对应的权限
    @Select("call pos_getSubjectPerms(#{roleName})")
    Set<Permission> getPermsList(String roleName);
}
