package com.hukarshu.accountservice.controller;

import com.hukarshu.accountservice.domain.Account;
import com.hukarshu.accountservice.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: hukarshu
 * @Date: 2019/4/8 15:12
 * @Description:
 */
@RestController
public class AccountController {
    @Autowired
    AccountService accountService;

    @GetMapping("/{name}")
    public Account one(@PathVariable String name) {
        return accountService.findByNickname(name);
    }
}
