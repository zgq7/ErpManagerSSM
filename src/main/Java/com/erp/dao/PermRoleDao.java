package com.erp.dao;

import com.erp.pojo.Customer;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by zgq7 on 2019/1/11.
 * 获取subject的角色和权限
 * 用户登录通过之后才能进入此接口
 * 希望---》调用存储过程
 * */
public interface PermRoleDao {
    //传入用户名（先照常使用卡号），获取用户角色
    @Select("call pos_getSubjetRole(#{cardNo})")
    List<String> getSubjectRole(String cardNo);
    //传入用户名（先照常使用卡号），获取用户信息
    @Select("select * from erp_customer where cardNo = #{cardNo}")
    Customer getCustomerInfo(String cardNo);
}
