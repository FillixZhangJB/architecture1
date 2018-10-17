package com.sishuok.architecture1.customtermgr.dao;

import com.sishuok.architecture1.common.basedao.MyBaseMapper;
import com.sishuok.architecture1.customtermgr.vo.CustomerModel;
import com.sishuok.architecture1.customtermgr.vo.CustomerQueryModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by zjb on 2018/9/25.
 */
public interface CustomerMapper extends MyBaseMapper<CustomerModel> {

    List<CustomerQueryModel> selectByCondition(CustomerQueryModel cqm);

    CustomerModel selectByCustomerId(@Param("customerId") String customerId);

}
