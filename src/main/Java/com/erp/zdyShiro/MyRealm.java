package com.erp.zdyShiro;

import com.erp.dao.RegLogCustomerDao;
import com.erp.service.PermRoleService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Administrator on 2019/1/11.
 * 配置自定义realm,获取用户权限，角色等信息
 */
public class MyRealm extends AuthorizingRealm {
    private static final Logger log = LoggerFactory.getLogger(MyRealm.class);
    @Autowired
    private PermRoleService permRoleService;
    @Autowired
    private RegLogCustomerDao regLogCustomerDao;

    /**
     * @param principalCollection 实际上是subject
     * @return 返回用户权限信息
     * 用户授权
     **/
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        log.info("-------------->开始授权");
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        //得到用户名
        Object username = principalCollection.getPrimaryPrincipal();
        //通过用户名进行进行角色匹配
        Set<String> roles = permRoleService.getRoles(String.valueOf(username));
        Set<String> perms = permRoleService.getPerms(roles);
        log.info("用户具有的角色", simpleAuthorizationInfo.getRoles());
        simpleAuthorizationInfo.setRoles(roles);
        simpleAuthorizationInfo.setStringPermissions(perms);
        return simpleAuthorizationInfo;
    }

    /**
     * @param authenticationToken 实际是subject.login(token)中的token
     * @return 返回用户角色信息
     * 用户验证能进入到这里，说明已经通过验证了
     **/
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        log.info("----------->开始认证");
        //获取用户名，没必要获取密码
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        //principal就是用户名~~~~~~
        //利用token得到用户名以及密码
        String username = authenticationToken.getPrincipal().toString();
        String password = String.valueOf(token.getPassword());
        Boolean loginStatus = Boolean.valueOf(regLogCustomerDao.Login(username, password));
        log.info("----------------> 认证状态：{}", loginStatus?"成功":"失败");
        //loginStatus为true则认证成功，反之异常
        if (!loginStatus) {
            log.info("-----------------------》认证失败");
            //抛出认证异常
            throw new AuthenticationException();
        }
       /* //进行加盐处理
        String salt = "abcdefg";
        ByteSource credentialSalt = new Md2Hash(salt);*/
        //调用父类getName 方法得到当前realm的name
        String realmName = getName();
        //返回具体实例 SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(principal, credentials, credentialSalt, realmName);
        return new SimpleAuthenticationInfo("MD5",password,new Md5Hash(username),realmName);
    }

    //init-method 配置.
    public void setCredentialMatcher() {
        HashedCredentialsMatcher credentialsMatcher = new HashedCredentialsMatcher();
        credentialsMatcher.setHashAlgorithmName("MD5");//MD5算法加密
        credentialsMatcher.setHashIterations(1024);//1024次循环加密
        setCredentialsMatcher(credentialsMatcher);
    }

    //用来测试的算出密码password盐值加密后的结果，下面方法用于新增用户添加到数据库操作的，我这里就直接用main获得，直接数据库添加了，省时间
    public static void main(String[] args) {
        String saltSource = "admin";
        String hashAlgorithmName = "MD5";
        String credentials = "password";
        Object salt = new Md5Hash(saltSource);
        int hashIterations = 1024;
        Object result = new SimpleHash(hashAlgorithmName, credentials, salt, hashIterations);
        System.out.println(result);
    }
}
