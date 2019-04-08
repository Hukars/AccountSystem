package com.hukarshu.accountservice.domain;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * @Auther: hukarshu
 * @Date: 2019/4/8 11:22
 * @Description:
 */
public class Saving {
    @NotNull
    private BigDecimal amount;


    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
