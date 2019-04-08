package com.hukarshu.accountservice.domain;


import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @Auther: hukarshu
 * @Date: 2019/4/8 11:19
 * @Description:
 */
@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ITEM_ID")
    private long id;

    //收支项名称
    @NotNull
    private String title;

    //收支项数额
    @NotNull
    private BigDecimal amount;

    //收支项货币形式
    @NotNull
    private Currency currency;

    //收支项的添加时间
    @NotNull
    private Date addTime;

    //收支项的对应图标
    @NotNull
    private String icon;

    //是否是收入项
    @NotNull
    private Boolean isIncome;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }


}
