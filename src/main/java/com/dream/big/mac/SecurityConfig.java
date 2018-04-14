package com.dream.big.mac;

import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.dao.ReflectionSaltSource;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/**
 * @Author: JiangChen
 * @Description:权限控制
 * @Date 2018/4/14 0:15
 */
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //禁用csrf
        http.csrf().disable();

        http.authorizeRequests()
                .antMatchers( "/images/**", "/css/**", "/styles/**").permitAll()
                .anyRequest().authenticated()
                .and().formLogin()
                .loginPage("/login")
                .successHandler(new CustomAuthenticaionSuccessHandler("/index"))
                .permitAll()
                .and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))//退出登录
                .logoutSuccessUrl("/login")//退出成功跳转
                .invalidateHttpSession(true)//注销session
                .permitAll();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService());
        auth.authenticationProvider(authenticationProvider());
    }

    @Bean
    public BigMacUserDetailService userDetailsService() {
        return new BigMacUserDetailService();
    }

    @Bean
    public BigMacAuthenticationProvider authenticationProvider() {
        return new BigMacAuthenticationProvider();
    }

    @Bean
    public ShaPasswordEncoder passwordEncoder() {
        return new ShaPasswordEncoder();
    }

   @Bean
    public ReflectionSaltSource saltSource() {
        ReflectionSaltSource ret = new ReflectionSaltSource();
        ret.setUserPropertyToUse("username");
        return ret;
    }

}
