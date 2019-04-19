package com.hukarshu.statisticservice.domain;

import java.math.BigDecimal;

/**
 * @Auther: hunan
 * @Date: 19/04/2019 14:54
 * @Description:
 */
public class FinancialBriefing {
    //本月第几天
    private Integer currentDay;

    //总记账次数
    private Integer totalRecords;

    //本月预算
    private BigDecimal budget;

    //已使用
    private BigDecimal use;

    //剩余
    private BigDecimal remaining;
}
