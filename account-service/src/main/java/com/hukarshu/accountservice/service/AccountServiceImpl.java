package com.hukarshu.accountservice.service;

import com.hukarshu.accountservice.domain.Account;
import com.hukarshu.accountservice.domain.Saving;
import com.hukarshu.accountservice.domain.User;
import com.hukarshu.accountservice.repository.AccountRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.Date;

/**
 * @Auther: hukarshu
 * @Date: 2019/4/8 15:34
 * @Description:
 */
@Service
public class AccountServiceImpl implements AccountService {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    AccountRepository accountRepository;

    @Override
    public Account findByNickname(String nickname){
        if(!nickname.isEmpty())
            return accountRepository.findByNickname(nickname);
        return null;
    }

    @Override
    public Account createAccount(User user){
        Account existing = accountRepository.findByNickname(user.getUsername());
        Assert.isNull(existing,"User already exists:"+user.getUsername());

        //authClient.createUser(user);
        //Saving saving = new Saving();

        Account account = new Account();
        account.setNickname(user.getUsername());
        account.setLastLogin(new Date());

        accountRepository.save(account);

        log.info("New Account has been created:"+user.getUsername());
        return  account;
    }


}
