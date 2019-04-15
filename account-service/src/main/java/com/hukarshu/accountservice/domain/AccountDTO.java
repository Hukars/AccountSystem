package com.hukarshu.accountservice.domain;

import java.util.Date;
import java.util.List;

/**
 * @Auther: hukarshu
 * @Date: 2019/4/10 16:31
 * @Description:
 */
public class AccountDTO {

    private List<Item> itemList;

    private String note;

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }


}
