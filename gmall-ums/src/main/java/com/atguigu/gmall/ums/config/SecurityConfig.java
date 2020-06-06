package com.atguigu.gmall.ums.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * TODO 因为配置了spring-security，所以需要放行所有请求。
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    protected void configure(HttpSecurity http) throws Exception {
        //1.所有授权请求通过匹配器都允许通过
        http.authorizeRequests().antMatchers("/**").permitAll();

        //2.在Security的默认拦截器里，默认会开启CSRF处理，判断请求是否携带了token，如果没有就拒绝访问。所以我们得禁用掉csrf
        http.csrf().disable();
    }
}
