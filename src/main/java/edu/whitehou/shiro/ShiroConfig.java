package edu.whitehou.shiro;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author : white.hou
 * @description : shiro配置类
 * @date: 2018/11/10_19:49
 */
@Configuration
public class ShiroConfig {
    /**
     * 创建ShiroFilterFactoryBean
     */
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("defaultWebSecurityManager") DefaultWebSecurityManager defaultWebSecurityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        /**
         * 关联securityManager
         */
        shiroFilterFactoryBean.setSecurityManager(defaultWebSecurityManager);
        /**
         * 添加Shiro内置过滤器
         * 常用：
         *    anon:无需认证（登录）就能访问
         *    authc:必须认证才能访问
         *    user:使用rememberMe功能可以直接访问
         *    perms:该资源必须得到资源权限才能访问
         *    role:该资源必须得到角色权限才能访问
         */
        Map<String, String> filterMap = new LinkedHashMap<>();
        filterMap.put("/", "authc");
        filterMap.put("/commons/*","authc");
       // filterMap.put("/*/**","authc");
        /**
         * 添加授权逻辑 ，未获得授权调转到指定页面
         */
        filterMap.put("/user/*", "perms[user:root]");
        filterMap.put("/root/*","perms[admin:root]");
        filterMap.put("/order/*","perms[order:root]");
        filterMap.put("/product/*","perms[product:root]");

        /**
         * 跳转到指定页面,参数为@RequsetMapping
         */
        shiroFilterFactoryBean.setLoginUrl("/tologin");
        shiroFilterFactoryBean.setUnauthorizedUrl("/noAuth");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);
        return shiroFilterFactoryBean;
    }

    /**
     * 创建DefaultWebSecurityManager
     * @param rootRealm
     * @return
     */
    @Bean(name = "defaultWebSecurityManager")
    public DefaultWebSecurityManager defaultWebSecurityManager(@Qualifier("rootRealm") RootRealm rootRealm){
        DefaultWebSecurityManager defaultWebSecurityManager=new DefaultWebSecurityManager();
        /**
         * 关联Realm
         */
        defaultWebSecurityManager.setRealm(rootRealm);
        return defaultWebSecurityManager;
    }
    /**
     * 创建RootRealm
     * @return
     */
    @Bean(name = "rootRealm")
    public RootRealm getRootRealm(){
    return new RootRealm();
   }
}
