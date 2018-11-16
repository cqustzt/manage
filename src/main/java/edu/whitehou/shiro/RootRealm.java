package edu.whitehou.shiro;

import edu.whitehou.entity.Root;
import edu.whitehou.service.service.RootService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;

/**
 * @author : white.hou
 * @description : 关联管理员用户的Realm
 * @date: 2018/11/10_19:49
 */
public class RootRealm extends AuthorizingRealm {
    @Autowired
    private RootService rootService;

    /**
     * 执行认证逻辑
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        Logger loggerAuthenticationInfo  =LoggerFactory.getLogger(getClass());
        loggerAuthenticationInfo.info("执行认证逻辑");
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) authenticationToken;
        /**
         * 判断接收到的信息
         */
        loggerAuthenticationInfo.debug("获取到的账号: " + usernamePasswordToken.getUsername() + "," + "获取到的密码: " + Arrays.toString(usernamePasswordToken.getPassword()));
        Root root=rootService.findRootTokenByRootName(usernamePasswordToken.getUsername());
        if (root == null) {
            /**
             * Shiro底层返回 UnknownAccountException
             */
            return null;
        }
        /**
         * 判断密码
         */
        return new SimpleAuthenticationInfo(root, root.getPassword(), "");
    }

    /**
     * 资源授权
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        Logger loggerAuthorizationInfo =LoggerFactory.getLogger(getClass());
        loggerAuthorizationInfo.info("执行授权逻辑");
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        Subject subject=SecurityUtils.getSubject();
        Root root=(Root)subject.getPrincipal();
        Root dbRoot=rootService.findRootTokenByRootName(root.getUserName());
        simpleAuthorizationInfo.addStringPermission(dbRoot.getIdentity());
        loggerAuthorizationInfo.debug("获取到的数据库对象的名字是： "+root.getUserName()+"获取到的数据库对象的身份标识是： "+root.getIdentity());
        return simpleAuthorizationInfo;
    }
}
