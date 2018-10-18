package com.sishuok.architecture1.cartmgr.vo;

import com.sishuok.architecture1.common.model.BaseModel;

import javax.persistence.*;

@Table(name = "tbl_cart")
public class TblCart extends BaseModel{
    @Id
    private String uuid;

    @Column(name = "customerUuid")
    private String customerUuid;

    @Column(name = "goodsUuid")
    private String goodsUuid;

    @Column(name = "buyNum")
    private Integer buyNum;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getCustomerUuid() {
        return customerUuid;
    }

    public void setCustomerUuid(String customerUuid) {
        this.customerUuid = customerUuid;
    }

    public String getGoodsUuid() {
        return goodsUuid;
    }

    public void setGoodsUuid(String goodsUuid) {
        this.goodsUuid = goodsUuid;
    }

    public Integer getBuyNum() {
        return buyNum;
    }

    public void setBuyNum(Integer buyNum) {
        this.buyNum = buyNum;
    }
}