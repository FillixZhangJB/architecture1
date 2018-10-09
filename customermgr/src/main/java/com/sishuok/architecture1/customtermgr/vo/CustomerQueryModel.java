package com.sishuok.architecture1.customtermgr.vo;


/**
 * Created by zjb on 2018/9/25.
 */
public class CustomerQueryModel extends CustomerModel {

    private String queryJsonStr;

    public String getQueryJsonStr() {
        return queryJsonStr;
    }

    public void setQueryJsonStr(String queryJsonStr) {
        this.queryJsonStr = queryJsonStr;
    }
}
