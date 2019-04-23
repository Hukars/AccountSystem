package com.hukarshu.statisticservice.domain;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: hunan
 * @Date: 19/04/2019 14:45
 * @Description:
 */
@Document(collection = "personalStatistics")
public class Statistics {

    @Id
    //用户名
    private String nickname;

    //资产概况
    @Valid
    @NotNull
    private Asset asset;

    //收支表
    @Valid
    @NotNull
    private BalanceSheet balanceSheet;

    //月财务简报
    @Valid
    @NotNull
    private FinancialBriefing financialBriefing;

    //本月分类支出
    private Map<String, BigDecimal> expenditureClassification;

    //本月支出趋势
    private Map<Integer, BigDecimal> expenditureTrend;

    public Statistics(){
        this.asset = new Asset();
        this.balanceSheet = new BalanceSheet();
        this.financialBriefing = new FinancialBriefing();
        this.expenditureClassification = new HashMap<>();
        this.expenditureTrend = new HashMap<>();
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Asset getAsset() {
        return asset;
    }

    public void setAsset(Asset asset) {
        this.asset = asset;
    }

    public BalanceSheet getBalanceSheet() {
        return balanceSheet;
    }

    public void setBalanceSheet(BalanceSheet balanceSheet) {
        this.balanceSheet = balanceSheet;
    }

    public FinancialBriefing getFinancialBriefing() {
        return financialBriefing;
    }

    public void setFinancialBriefing(FinancialBriefing financialBriefing) {
        this.financialBriefing = financialBriefing;
    }

    public Map<String, BigDecimal> getExpenditureClassification() {
        return expenditureClassification;
    }

    public Map<Integer, BigDecimal> getExpenditureTrend() {
        return expenditureTrend;
    }
}
