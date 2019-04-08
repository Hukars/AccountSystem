package com.hukarshu.accountservice.domain;

import javax.persistence.*;
import javax.validation.Valid;
import java.util.Date;
import java.util.List;
import org.hibernate.validator.constraints.Length;

/**
 * @Auther: hukarshu
 * @Date: 2019/4/8 10:49
 * @Description:
 */
/*
账户，对应一个用户的账单信息：采用自顶向下的方式，对于一个用户的财务状况来说，个人收支、资产、债务、税负、保险
收入，支出细化到月
 */
@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ACCOUNT_ID")
    private long id;

    //用户名
    @Column(name="NICK_NAME")
    private String nickname;

    //上一次登陆时间
    @Column(name="LAST_LOGIN")
    private Date lastLogin;
    /*
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = MonthlyItems.class)
    @JoinTable(name = "ACCOUNT_MONTHLYITEMSLIST", joinColumns = { @JoinColumn(name = "NICK_NAME") }, inverseJoinColumns = { @JoinColumn(name = "ROLE_ID") })
    private Set<Role> roles;
     */

    //每个月的收支状况
    @Valid
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = MonthlyItems.class)
    @JoinTable(name = "ACCOUNT_MONTHLYITEMSLIST", joinColumns = { @JoinColumn(name = "ACCOUNT_ID") }, inverseJoinColumns = { @JoinColumn(name = "MONTH_ID") })
    private List<MonthlyItems> monthlyItemsList;

//    //用户当前资产状况
//    @Valid
//    @ElementCollection(targetClass=Saving.class)
//    private List<Saving> savingList;

    //用户的个人备注
    @Length(min = 0, max = 1000)
    private String note;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    public List<MonthlyItems> getMonthlyItems() {
        return monthlyItemsList;
    }

    public void setMonthlyItems(List<MonthlyItems> monthlyItemsList) {
        this.monthlyItemsList = monthlyItemsList;
    }

//    public List<Saving> getSavingList() {
//        return savingList;
//    }
//
//    public void setSavingList(List<Saving> savingList) {
//        this.savingList = savingList;
//    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }



}
