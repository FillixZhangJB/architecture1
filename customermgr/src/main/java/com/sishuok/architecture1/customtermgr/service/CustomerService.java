package com.sishuok.architecture1.customtermgr.service;

import com.github.pagehelper.PageInfo;
import com.sishuok.architecture1.customtermgr.vo.CustomerModel;

/**
 * Created by zjb on 2018/9/28.
 */
public interface CustomerService {
    int insert(CustomerModel customerModel);

    PageInfo<CustomerModel> selectAllByPage(int pageNum, int pageSize);

    int updateWithVersion(CustomerModel customerModel);
}
