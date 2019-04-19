package com.hukarshu.statisticservice.domain;

import java.math.BigDecimal;

/**
 * @Auther: hunan
 * @Date: 19/04/2019 14:51
 * @Description:
 */
public class BalanceSheet {

    //本月第几天
    private Integer lastDay;

    //本月
    private Integer thisMonth;

    //本年
    private Integer thisYear;

    //本周收入
    private BigDecimal weekIncome;

    //本月收入
    private BigDecimal monthIncome;

    //本年收入
    private BigDecimal yearIncome;

    //本周支出
    private BigDecimal weekExpenditure;

    //本月支出
    private BigDecimal monthExpenditure;

    //本年支出
    private BigDecimal yearExpenditure;
}
