package com.hukarshu.accountservice.domain;

/**
 * @Auther: hukarshu
 * @Date: 2019/4/8 11:23
 * @Description:
 */
public enum Currency {
    CNY, USD, EUR, RUB;

    public static Currency getDefault() {
        return CNY;
    }
}
