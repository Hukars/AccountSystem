package com.hukarshu.accountservice.service;

import com.hukarshu.accountservice.client.AuthFeignClient;
import com.hukarshu.accountservice.domain.*;
import com.hukarshu.accountservice.repository.AccountRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

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

    @Resource
    AuthFeignClient authFeignClient;

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

        authFeignClient.createUser(user);
        //Saving saving = new Saving();

        Account account = new Account();
        account.setNickname(user.getUsername());
        account.setLastLogin(new Date());

        accountRepository.save(account);

        log.info("New Account has been created:"+user.getUsername());
        return  account;
    }

    @Override
    public void saveChanges(String nickname, AccountDTO newOne){
        Account account = accountRepository.findByNickname(nickname);
        Assert.notNull(account,"can't find account with name " + nickname);

        account.setLastLogin(new Date());
        account.setNote(newOne.getNote());
        if(!newOne.getItemList().isEmpty()) {
            List<MonthlyItems> tempList = account.getMonthlyItemsList();
            MonthlyItems monthlyItems =  getCurrentMonthItems(tempList);
            monthlyItems.getItems().addAll(newOne.getItemList());
        }

        accountRepository.save(account);

        log.debug("account {} changes has been saved", nickname);

    }

    private MonthlyItems getCurrentMonthItems(List<MonthlyItems> list){
        Calendar now = Calendar.getInstance();
        if(list.isEmpty()){
            MonthlyItems newMonthlyItems = new MonthlyItems(now.get(Calendar.YEAR),now.get(Calendar.MONTH) + 1,null);
            list.add(newMonthlyItems);
            return newMonthlyItems;
        }
        else{
            MonthlyItems  monthlyItems = list.get(list.size()-1);
            if(monthlyItems.getCurrentYear().equals(now.get(Calendar.YEAR)) && monthlyItems.getCurrentMonth().equals(now.get(Calendar.MONTH) + 1))
                return monthlyItems;
            else{
                MonthlyItems newMonthlyItems = new MonthlyItems(now.get(Calendar.YEAR),now.get(Calendar.MONTH) + 1,null);
                list.add(newMonthlyItems);
                return newMonthlyItems;
            }
        }
    }
}
