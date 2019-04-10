package com.hukarshu.authservice.service;

import com.hukarshu.authservice.domain.User;
import com.hukarshu.authservice.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.Optional;

/**
 * @Auther: hukarshu
 * @Date: 2019/4/1 15:46
 * @Description:
 */
@Service
public class UserServiceImpl implements UserService {
    private final Logger log = LoggerFactory.getLogger(getClass());
    //spring security提供的一个密码加密类，其过程不可逆，即对密码进行hash处理，然后将hash值存入数据库中，验证是通过hash值匹配
    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    @Autowired
    private UserRepository userRepository;

    @Override
    public void create(User user) {

        Optional<User> existing = userRepository.findById(user.getUsername());
        existing.ifPresent(it-> {throw new IllegalArgumentException("user already exists: " + it.getUsername());});

        String hash = encoder.encode(user.getPassword());
        user.setPassword(hash);

        userRepository.save(user);

        log.info("new user has been created: {}", user.getUsername());
    }

    @Override
    public void saveOne(String username,User newOne){
        User user = userRepository.findByUsername("hukarshu");
        Assert.notNull(user,"can't find user with name " + username);
        Assert.state(newOne.getPassword().length()<15,"the length of the password should be between 6 and 15");

        user.setPassword(encoder.encode(newOne.getPassword()));
        userRepository.save(user);

        log.info("password has been changed:{}",username);
    }

}
