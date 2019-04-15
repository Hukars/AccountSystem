package com.hukarshu.accountservice.domain;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

/**
 * @Auther: hukarshu
 * @Date: 2019/4/8 14:21
 * @Description:
 */
@Entity
public class MonthlyItems {
    //当前的年月
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="MONTH_ID")
    private long id;

    @NotNull
    @Column(name="CURRENT_YEAR")
    private Integer currentYear;

    @NotNull
    @Column(name="CURRENT_MONTH")
    private Integer currentMonth;

    //本月收支情况
    @NotNull
    @Valid
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = Item.class)
    @JoinTable(name = "MONTHLYITEMSLIST_ITEM", joinColumns = { @JoinColumn(name = "MONTH_ID") }, inverseJoinColumns = { @JoinColumn(name = "ITEM_ID")})
    private List<Item> items;

    public MonthlyItems(Integer currentYear, Integer currentMonth, List<Item> items){
        this.currentYear = currentYear;
        this.currentMonth = currentMonth;
        this.items = items;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Integer getCurrentYear() {
        return currentYear;
    }

    public void setCurrentYear(Integer currentYear) {
        this.currentYear = currentYear;
    }

    public Integer getCurrentMonth() {
        return currentMonth;
    }

    public void setCurrentMonth(Integer currentMonth) {
        this.currentMonth = currentMonth;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

}
