package com.hukarshu.statisticservice.domain;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * @Auther: hunan
 * @Date: 19/04/2019 14:54
 * @Description:
 */
public class FinancialBriefing {
    //本月第几天
    @NotNull
    private Integer currentDay;

    //总记账次数
    @NotNull
    private Integer totalRecords;

    //本月预算
    @NotNull
    private BigDecimal budget;

    //已使用
    @NotNull
    private BigDecimal use;

    //剩余
    @NotNull
    private BigDecimal remaining;

    public FinancialBriefing(){
        this.currentDay = 0;
        this.totalRecords = 0;
        this.budget = new BigDecimal("0.00");
        this.use = new BigDecimal("0.00");
        this.remaining = new BigDecimal("0.00");

    }

    public Integer getCurrentDay() {
        return currentDay;
    }

    public void setCurrentDay(Integer currentDay) {
        this.currentDay = currentDay;
    }

    public Integer getTotalRecords() {
        return totalRecords;
    }

    public void setTotalRecords(Integer totalRecords) {
        this.totalRecords = totalRecords;
    }

    public BigDecimal getBudget() {
        return budget;
    }

    public void setBudget(BigDecimal budget) {
        this.budget = budget;
    }

    public BigDecimal getUse() {
        return use;
    }

    public void setUse(BigDecimal use) {
        this.use = use;
    }

    public BigDecimal getRemaining() {
        return remaining;
    }

    public void setRemaining(BigDecimal remaining) {
        this.remaining = remaining;
    }
}
