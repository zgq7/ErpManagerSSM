package com.erp.zdyShiro;

import com.erp.dao.PermRoleDao;
import com.erp.pojo.Customer;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.Md2Hash;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Administrator on 2019/1/11.
 * 配置自定义realm,获取用户权限，角色等信息
 * */
public class myRealm extends AuthorizingRealm{
    private static final Logger log = LoggerFactory.getLogger( myRealm.class);
    @Autowired
    private PermRoleDao permRoleDao;
    private String pass;
    /**
     * @param principalCollection 实际上是subject
     * @return 返回用户权限信息
     * 用户授权
     * **/
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        //得到用户名
        Object username = principalCollection.getPrimaryPrincipal();
        //进行角色匹配
        if("admin".equals(username)){
            simpleAuthorizationInfo.addRole("admin");
        }if("user".equals(username)){
            simpleAuthorizationInfo.addRole("user");
        }
        simpleAuthorizationInfo.addRole("normal");
        log.info("用户具有的角色",simpleAuthorizationInfo.getRoles());
        return simpleAuthorizationInfo;
    }

    /**
     * @param authenticationToken 实际是subject.login(token)中的token
     * @return 返回用户角色信息
     * 用户验证能进入到这里，说明已经通过验证了
     **/
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        log.info("token?-->{}",authenticationToken.toString());
        //获取用户名，没必要获取密码
        Object principal = authenticationToken.getPrincipal();
        //利用username得到用户信息、角色
        Customer customer = permRoleDao.getCustomerInfo((String) principal);
        List<String> roles = permRoleDao.getSubjectRole((String) principal);
        if (!roles.isEmpty()){
            pass = customer.getCardNo();
        }
        String credentials = pass;
        //进行加盐处理
        String salt = "abcdefg";
        ByteSource credentialSalt = new Md2Hash(salt);
        //调用父类getName 方法得到当前realm的name
        String realmName = getName();
        //返回具体实例
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(principal,credentials,credentialSalt,realmName);
        return info;
    }

    //init-method 配置.
    public void setCredentialMatcher(){
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
