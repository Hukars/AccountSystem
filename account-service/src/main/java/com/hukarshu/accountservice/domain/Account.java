package com.hukarshu.accountservice.domain;

import javax.persistence.Entity;
import java.util.Date;
import java.util.List;
import lombok.Data;

/**
 * @Auther: hukarshu
 * @Date: 2019/4/8 10:49
 * @Description:
 */
/*
账户，对应一个用户的账单信息：采用自顶向下的方式，对于一个用户的财务状况来说，个人收支、资产、债务、税负、保险
 */
@Data
@Entity
public class Account {
    private String nickname;

    private Date lastLogin;

    private List<Item> incomes;

    private List<Item> costs;

    private Saving saving;
}
