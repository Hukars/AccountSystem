package com.hukarshu.authservice.repository;

import com.hukarshu.authservice.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * @Auther: hukarshu
 * @Date: 2019/4/1 14:15
 * @Description:
 */
@Repository
public interface UserRepository extends JpaRepository<User,String> {
    User findByUsername(String username);
}
