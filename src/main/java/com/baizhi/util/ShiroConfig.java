package com.baizhi.util;

import com.baizhi.cache.MyCacheManager;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.mgt.RememberMeManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.Cookie;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 自定义Shiro工具类
 * 2018年12月19日 20点26分
 *      主要负责的功能：
 *           创建ShiroFilterFactoryBean对象
 *           创建RememberMe 免登陆功能
 *           实现 "授权" 功能
 */

@Configuration
public class ShiroConfig {

    @Value("${jedis.host}")
    private String host;
    @Value("${jedis.port}")
    private int port;

    // 第一步：创建ShiroFilterFactoryBean对象
    @Bean
    public ShiroFilterFactoryBean createShiroFilterFactoryBean(){

        // 创建ShiroFilterFcatoryBean对象 并且 赋值属性
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        // 注入：核心管理器对象
        shiroFilterFactoryBean.setSecurityManager(createDefaultWebSecurityManager());
        // 赋值：登陆路径
        shiroFilterFactoryBean.setLoginUrl("/views/login.jsp");
        // 赋值：登陆错误路径
        shiroFilterFactoryBean.setUnauthorizedUrl("/views/error.jsp");
        // 赋值：过滤器链 (利用Map集合赋值)
        Map<String,String> map = new HashMap<String,String>();
        map.put("/css/**","anon");
        map.put("/img/**","anon");
        map.put("/js/**","anon");
        map.put("/admin/**","anon");
        map.put("/views/login.jsp","anon");
        map.put("/views/regist.jsp","anon");
        map.put("/**","user");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(map);

        return shiroFilterFactoryBean;
    }

    //第二步： 创建项目安全管理器
    @Bean
    public DefaultWebSecurityManager createDefaultWebSecurityManager(){

        // 创建的是Web项目 所以使用 默认的Web项目安全管理器
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        // 创建数据源集合
        securityManager.setRealms(Arrays.asList(createShiroConfig()));
        // 创建记住我RememberMe
        securityManager.setRememberMeManager(createRememberMeManger());
        // 创建缓存管理器
        securityManager.setCacheManager(createCacheManager());

        return securityManager;
    }

    //第三步： 创建配置文件引用
    @Bean
    public RealmConfig createShiroConfig(){

        RealmConfig realmConfig = new RealmConfig();
        realmConfig.setCredentialsMatcher(createCredentialManager());
        return realmConfig;
    }

    //第四步： 创建加密凭证类型
    @Bean
    public HashedCredentialsMatcher createCredentialManager(){
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
        hashedCredentialsMatcher.setHashAlgorithmName("MD5");
        return hashedCredentialsMatcher;
    }

    //第五步： 完成记住我功能
    @Bean
    public RememberMeManager createRememberMeManger(){

        // 创建以Cookie为基础的RememberMe对象
        CookieRememberMeManager cookieRememberMeManager = new CookieRememberMeManager();
        // 配置Cookie的信息
        Cookie cookie = cookieRememberMeManager.getCookie();
        cookie.setMaxAge(604800);
        // 将cookie放入RememberMe对象
        cookieRememberMeManager.setCookie(cookie);
        return cookieRememberMeManager;
    }

    //第六步： 创建缓存管理器
    @Bean
    public CacheManager createCacheManager(){
        return new MyCacheManager(host,port);
    }

}
