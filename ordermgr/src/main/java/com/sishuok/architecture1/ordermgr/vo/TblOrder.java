package com.sishuok.architecture1.ordermgr.vo;

import javax.persistence.*;

@Table(name = "tbl_order")
public class TblOrder {
    @Id
    private String uuid;

    @Column(name = "customerUuid")
    private String customerUuid;

    @Column(name = "orderTime")
    private String orderTime;

    @Column(name = "totalMoney")
    private Float totalMoney;

    @Column(name = "saveMoney")
    private Float saveMoney;

    private Short state;

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

    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }

    public Float getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(Float totalMoney) {
        this.totalMoney = totalMoney;
    }

    public Float getSaveMoney() {
        return saveMoney;
    }

    public void setSaveMoney(Float saveMoney) {
        this.saveMoney = saveMoney;
    }

    public Short getState() {
        return state;
    }

    public void setState(Short state) {
        this.state = state;
    }
}