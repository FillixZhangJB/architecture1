package com.sishuok.architecture1.customtermgr.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sishuok.architecture1.customtermgr.dao.CustomerMapper;
import com.sishuok.architecture1.customtermgr.service.CustomerService;
import com.sishuok.architecture1.customtermgr.vo.CustomerModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by zjb on 2018/9/28.
 */
@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerMapper customerMapper;

    @Override
    public int insert(CustomerModel customerModel) {
        int result = customerMapper.insert(customerModel);
        if (result == 0) {
            new RuntimeException("出错了");
        }
        return result;
    }

    @Override
    public PageInfo<CustomerModel> selectAllByPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<CustomerModel> customerModels = this.customerMapper.selectAll();
        PageInfo pageInfo = new PageInfo(customerModels);
        return pageInfo;
    }

    @Override
    public int updateWithVersion(CustomerModel customerModel) {
        int result = this.customerMapper.updateByPrimaryKeyWithVersion(customerModel);
        return result;
    }
}
