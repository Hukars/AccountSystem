package com.hukarshu.accountservice.domain;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

/**
 * @Auther: hukarshu
 * @Date: 2019/4/8 10:40
 * @Description:
 */
public class User {
    @NotNull
    @Length(min = 6,max = 15)
    private String username;

    @NotNull
    @Length(min = 6,max = 15)
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
