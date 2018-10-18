package com.sishuok.architecture1.ordermgr.service;

import com.sishuok.architecture1.cartmgr.vo.TblCart;
import com.sishuok.architecture1.common.baseservice.BaseService;
import com.sishuok.architecture1.ordermgr.vo.TblOrder;

import java.util.List;

/**
 * Created by zjb on 2018/10/17.
 */
public interface OrderService extends BaseService<TblOrder> {
    int order(String customerUuid, List<TblCart> list);
}
