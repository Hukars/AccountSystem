package com.hukarshu.statisticservice.domain;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @Auther: hunan
 * @Date: 21/04/2019 10:59
 * @Description:
 */
public class Item {
    //收支项名称
    @NotNull
    private String title;

    //收支项数额
    @NotNull
    private BigDecimal amount;

    //收支项的添加时间
    @NotNull
    private Date addTime;

    //收支项的对应图标
    @NotNull
    private String icon;

    //条目类型
    @NotNull
    private ItemType itemType;

    //收支项的备注
    private String remark;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public ItemType getItemType() {
        return itemType;
    }

    public void setItemType(ItemType itemType) {
        this.itemType = itemType;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
