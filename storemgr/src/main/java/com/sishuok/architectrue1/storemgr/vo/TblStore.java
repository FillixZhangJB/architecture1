package com.sishuok.architectrue1.storemgr.vo;

import javax.persistence.*;

@Table(name = "tbl_store")
public class TblStore {
    @Id
    private Integer uuid;

    @Column(name = "goodsUuid")
    private String goodsUuid;

    @Column(name = "storeNum")
    private String storeNum;

    /**
     * @return uuid
     */
    public Integer getUuid() {
        return uuid;
    }

    /**
     * @param uuid
     */
    public void setUuid(Integer uuid) {
        this.uuid = uuid;
    }


    public String getGoodsUuid() {
        return goodsUuid;
    }

    public void setGoodsUuid(String goodsUuid) {
        this.goodsUuid = goodsUuid;
    }

    public String getStoreNum() {
        return storeNum;
    }

    public void setStoreNum(String storeNum) {
        this.storeNum = storeNum;
    }
}