package com.hukarshu.accountservice.repository;

import com.hukarshu.accountservice.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Auther: hukarshu
 * @Date: 2019/4/8 10:56
 * @Description:
 */
@Repository
public interface AccountRepository extends JpaRepository<Account, String> {
    Account findByNickname(String nickname);
}
