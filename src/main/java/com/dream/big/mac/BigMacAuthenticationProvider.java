package com.dream.big.mac;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.ReflectionSaltSource;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

/**
 * @Author: JiangChen
 * @Description:
 * @Date 2018/4/14 0:51
 */
public class BigMacAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private BigMacUserDetailService bigMacUserDetailService;

    @Autowired
    private ShaPasswordEncoder passwordEncoder;

    @Autowired
    private ReflectionSaltSource saltSource;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = String.valueOf(authentication.getPrincipal()).toLowerCase();
        String password = String.valueOf(authentication.getCredentials());
        UserDetails user = bigMacUserDetailService.loadUserByUsername(username);
        if(passwordEncoder.isPasswordValid(user.getPassword(), password, saltSource.getSalt(user))){
            List<GrantedAuthority> authorityList = (List<GrantedAuthority>) user.getAuthorities();
            return new UsernamePasswordAuthenticationToken(user, password, authorityList);
        }
        return null;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
    }
}
