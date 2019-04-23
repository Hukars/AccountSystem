package com.hukarshu.statisticservice.domain;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * @Auther: hunan
 * @Date: 19/04/2019 14:51
 * @Description:
 */
public class BalanceSheet {

    //本月
    @NotNull
    private Integer thisMonth;

    //本年
    @NotNull
    private Integer thisYear;

    //本月收入
    @NotNull
    private BigDecimal monthIncome;

    //本年收入
    @NotNull
    private BigDecimal yearIncome;

    //本月支出
    @NotNull
    private BigDecimal monthExpenditure;

    //本年支出
    @NotNull
    private BigDecimal yearExpenditure;

    public BalanceSheet(){
        this.thisMonth = 0;
        this.thisYear = 0;
        this.monthIncome = new BigDecimal("0.00");
        this.yearIncome = new BigDecimal("0.00");
        this.monthExpenditure = new BigDecimal("0.00");
        this.yearExpenditure = new BigDecimal("0.00");

    }


    public Integer getThisMonth() {
        return thisMonth;
    }

    public void setThisMonth(Integer thisMonth) {
        this.thisMonth = thisMonth;
    }

    public Integer getThisYear() {
        return thisYear;
    }

    public void setThisYear(Integer thisYear) {
        this.thisYear = thisYear;
    }

    public BigDecimal getMonthIncome() {
        return monthIncome;
    }

    public void setMonthIncome(BigDecimal monthIncome) {
        this.monthIncome = monthIncome;
    }

    public BigDecimal getYearIncome() {
        return yearIncome;
    }

    public void setYearIncome(BigDecimal yearIncome) {
        this.yearIncome = yearIncome;
    }

    public BigDecimal getMonthExpenditure() {
        return monthExpenditure;
    }

    public void setMonthExpenditure(BigDecimal monthExpenditure) {
        this.monthExpenditure = monthExpenditure;
    }

    public BigDecimal getYearExpenditure() {
        return yearExpenditure;
    }

    public void setYearExpenditure(BigDecimal yearExpenditure) {
        this.yearExpenditure = yearExpenditure;
    }

}
