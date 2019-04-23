package com.hukarshu.statisticservice.domain;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * @Auther: hunan
 * @Date: 19/04/2019 14:48
 * @Description:
 */
public class Asset {


    //当前资产
    @NotNull
    private BigDecimal currentAsset;

    //负债
    @NotNull
    private BigDecimal debt;

    //应收债
    @NotNull
    private BigDecimal collectDebt;

    //净资产
    @NotNull
    private BigDecimal netAsset;

    public Asset(){
        this.currentAsset = new BigDecimal("0.00");
        this.debt = new BigDecimal("0.00");
        this.collectDebt = new BigDecimal("0.00");
        this.netAsset = new BigDecimal("0.00");
    }

    public BigDecimal getCurrentAsset() {
        return currentAsset;
    }

    public void setCurrentAsset(BigDecimal currentAsset) {
        this.currentAsset = currentAsset;
    }

    public BigDecimal getDebt() {
        return debt;
    }

    public void setDebt(BigDecimal debt) {
        this.debt = debt;
    }

    public BigDecimal getCollectDebt() {
        return collectDebt;
    }

    public void setCollectDebt(BigDecimal collectDebt) {
        this.collectDebt = collectDebt;
    }

    public BigDecimal getNetAsset() {
        return netAsset;
    }

    public void setNetAsset(BigDecimal netAsset) {
        this.netAsset = netAsset;
    }


}
