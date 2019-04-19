package com.hukarshu.statisticservice.domain;

import javax.persistence.*;

/**
 * @Auther: hunan
 * @Date: 19/04/2019 14:45
 * @Description:
 */
@Entity
public class Statistics {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ACCOUNT_ID")
    private long id;

    //用户名
    @Column(name="NICK_NAME")
    private String nickname;

    //资产概况
    private Asset asset;

    //收支表
    private BalanceSheet balanceSheet;

    //月财务简报
    private FinancialBriefing financialBriefing;

    //本月支出统计
    private ExpenditureStatistics expenditureStatistics;

}
