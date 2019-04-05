package com.hukarshu.authservice.service;

import com.hukarshu.authservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @Auther: hukarshu
 * @Date: 2019/4/1 14:12
 * @Description:
 */

@Service
public class MySqlUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository.findById(username).orElseThrow(()->new UsernameNotFoundException(username));
    }
}
