package com.hukarshu.authservice.domain;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;

/**
 * @Auther: hukarshu
 * @Date: 2019/4/1 14:17
 * @Description:
 */
@Entity
public class User implements UserDetails {
    @Id
    private String username;

    private String password;

    @Override
    public String getUsername() {
        return username;
    }

    public void setUserName(String username){
        this.username = username;
    }

    @Override
    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password = password;
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

    @Override
    public List<GrantedAuthority> getAuthorities() {
        return null;
    }
}