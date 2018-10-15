package com.sishuok.architecture1.customtermgr.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.sishuok.architecture1.customtermgr.vo.CustomerModel;
import com.sishuok.architecture1.customtermgr.vo.CustomerQueryModel;

/**
 * Created by zjb on 2018/9/28.
 */
public interface CustomerService {
    int insert(CustomerModel customerModel);

    PageInfo<CustomerModel> selectAllByPage(int pageNum, int pageSize);

    int updateWithVersion(CustomerModel customerModel);

    CustomerModel selectByPk(String pk);

    int delete(String pk);

    PageInfo<CustomerQueryModel> selectByConditionPage(CustomerQueryModel cqm);

    CustomerModel selectByCustomerId(String customerId);


}
