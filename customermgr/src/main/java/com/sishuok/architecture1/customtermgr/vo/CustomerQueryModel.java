package com.sishuok.architecture1.customtermgr.vo;

import com.sishuok.architecture1.customtermgr.pageutil.Page;

/**
 * Created by zjb on 2018/9/25.
 */
public class CustomerQueryModel extends CustomerModel {
    Page<CustomerModel> page = new Page<CustomerModel>();

    public Page<CustomerModel> getPage() {
        return page;
    }

    public void setPage(Page<CustomerModel> page) {
        this.page = page;
    }
}
