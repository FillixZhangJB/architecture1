package com.sishuok.architecture1.customtermgr.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sishuok.architecture1.customtermgr.dao.CustomerMapper;
import com.sishuok.architecture1.customtermgr.service.CustomerService;
import com.sishuok.architecture1.customtermgr.vo.CustomerModel;
import com.sishuok.architecture1.customtermgr.vo.CustomerQueryModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

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
        int result = customerMapper.updateByPrimaryKeyWithVersion(customerModel);
//        Example example = new Example(CustomerModel.class);
//        example.and().andCondition("uuId=", customerModel.getUuId());
//        int result = this.customerMapper.updateByExample(customerModel, example);
        return result;
    }

    @Override
    public CustomerModel selectByPk(String pk) {
        CustomerModel customerModel = customerMapper.selectByPrimaryKey(pk);
//        Example example = new Example(CustomerModel.class);
//        example.and().andCondition("uuId=", pk);
//        CustomerModel customerModel = customerMapper.selectOneByExample(example);
        return customerModel;
    }

    @Override
    public int delete(String pk) {
        int result = customerMapper.deleteByPrimaryKey(pk);
        return result;
    }

    @Override
    public PageInfo<CustomerQueryModel> selectByConditionPage(CustomerQueryModel cqm) {
        PageHelper.startPage(1, 20);
        List<CustomerQueryModel> customerQueryModels = customerMapper.selectByCondition(cqm);
        PageInfo<CustomerQueryModel> customerQueryModelPageInfo = new PageInfo<>(customerQueryModels);
        return customerQueryModelPageInfo;
    }

    @Override
    public CustomerModel selectByCustomerId(String customerId) {
        return customerMapper.selectByCustomerId(customerId);
    }

    public Page<CustomerQueryModel> selectPageByCondition(CustomerQueryModel customerQueryModel) {
        Example example = new Example(CustomerModel.class);
        return null;
    }
}
