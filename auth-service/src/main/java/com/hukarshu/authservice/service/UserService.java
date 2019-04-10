package com.hukarshu.authservice.service;

import com.hukarshu.authservice.domain.User;

/**
 * @Auther: hukarshu
 * @Date: 2019/4/1 15:45
 * @Description:
 */
public interface UserService {
    void create(User user);

    void saveOne(String name,User user);

}
