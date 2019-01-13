package com.erp.service.serviceImpl;

import com.erp.dao.PermRoleDao;
import com.erp.pojo.Permission;
import com.erp.pojo.Role;
import com.erp.service.PermRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by zgq7 on 2019/1/13 0013.
 * 获取具体的权限和角色
 */
@Service("permRoleService")
@Transactional
public class PermRoleServiceImpl implements PermRoleService {
    @Autowired
    private PermRoleDao permRoleDao;

    @Override
    public Set<String> getRoles(String username) {
        Set<Role> roles = permRoleDao.getSubjectRole(username);
        Set<String> rightRoles = new HashSet<>();
        for (Role rele : roles) {
            rightRoles.add(rele.getRoleName());
        }
        return rightRoles;
    }

    @Override
    public Set<String> getPerms(Set<String> rightRoles) {
        Set<String> resultPerms = new HashSet<>();
        for (String roleNmae : rightRoles) {
            Set<Permission> permissions = permRoleDao.getPermsList(roleNmae);
            for (Permission permission : permissions) {
                resultPerms.add(permission.getPerms());
            }
        }
        return resultPerms;
    }
}
