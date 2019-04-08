package com.hukarshu.accountservice.service;

import com.hukarshu.accountservice.domain.Account;
import com.hukarshu.accountservice.domain.User;

/**
 * @Auther: hukarshu
 * @Date: 2019/4/8 15:30
 * @Description:
 */
public interface AccountService {
    Account findByNickname(String nickName);

    Account createAccount(User user);
}
