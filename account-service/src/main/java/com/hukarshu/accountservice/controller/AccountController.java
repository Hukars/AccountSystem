package com.hukarshu.accountservice.controller;

import com.hukarshu.accountservice.domain.Account;
import com.hukarshu.accountservice.domain.User;
import com.hukarshu.accountservice.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;

/**
 * @Auther: hukarshu
 * @Date: 2019/4/8 15:12
 * @Description:
 */
@RestController
public class AccountController {
    @Autowired
    AccountService accountService;

    @PreAuthorize("#oauth2.hasScope('server')")
    @GetMapping("/{name}")
    public Account one(@PathVariable String name) {
        return accountService.findByNickname(name);
    }

    @GetMapping("/current")
    public Account getCurrentOne(Principal principal){return accountService.findByNickname(principal.getName());}

    @PutMapping("/current")
    public void saveCurrentOne(Principal principal,@Valid @RequestBody Account account){
        accountService.saveChanges(principal.getName(),account);
    }

    @PostMapping("/")
    public Account createOne(@Valid @RequestBody User user){
        return accountService.createAccount(user);
    }

    @PreAuthorize("#oauth2.hasScope('ui')")
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String hello(Principal principal) {
        return "hello, " + principal.getName();
    }
}
