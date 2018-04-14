package com.dream.big.mac;

import com.dream.big.mac.system.model.Role;
import com.dream.big.mac.system.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @Author: JiangChen
 * @Description:
 * @Date 2018/4/14 13:41
 */
public class BigMacUserDetails extends User implements UserDetails{

    private User user;

    private List<Role> roles;

    public BigMacUserDetails(User user, List<Role> roles) {
        this.user = user;
        this.roles = roles;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> auths = new ArrayList<>();
        for (Role r : roles) {
            auths.add(new SimpleGrantedAuthority(r.getRoleName()));
        }
        return auths;
    }

    @Override
    public String getUsername() {
        return user.getUserAccount();
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
