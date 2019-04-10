package com.hukarshu.accountservice.domain;

import java.util.Date;
import java.util.List;

/**
 * @Auther: hukarshu
 * @Date: 2019/4/10 16:31
 * @Description:
 */
public class AccountDTO {

    private List<MonthlyItems> monthlyItemsList;

    private String note;


    public List<MonthlyItems> getMonthlyItemsList() {
        return monthlyItemsList;
    }

    public void setMonthlyItemsList(List<MonthlyItems> monthlyItemsList) {
        this.monthlyItemsList = monthlyItemsList;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
