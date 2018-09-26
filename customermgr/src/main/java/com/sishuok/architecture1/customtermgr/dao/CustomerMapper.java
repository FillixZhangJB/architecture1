package com.sishuok.architecture1.customtermgr.dao;

import com.sishuok.architecture1.common.BaseMapper;
import com.sishuok.architecture1.customtermgr.vo.CustomerModel;
import com.sishuok.architecture1.customtermgr.vo.CustomerQueryModel;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by zjb on 2018/9/25.
 */
@Repository
public interface CustomerMapper extends BaseMapper<CustomerModel, CustomerQueryModel> {

}
