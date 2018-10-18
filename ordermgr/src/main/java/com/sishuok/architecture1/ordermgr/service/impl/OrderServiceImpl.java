package com.sishuok.architecture1.ordermgr.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sishuok.architecture1.cartmgr.vo.TblCart;
import com.sishuok.architecture1.ordermgr.dao.TblOrderMapper;
import com.sishuok.architecture1.ordermgr.service.OrderService;
import com.sishuok.architecture1.ordermgr.vo.TblOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by zjb on 2018/10/17.
 */
@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    @Autowired
    TblOrderMapper orderMapper;

    @Override
    public int insert(TblOrder tblOrder) {
        return orderMapper.insert(tblOrder);
    }

    @Override
    public PageInfo<TblOrder> selectAllByPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return new PageInfo<>(orderMapper.selectAll());
    }

    @Override
    public int updateWithVersion(TblOrder tblOrder) {
        return orderMapper.updateByPrimaryKeyWithVersion(tblOrder);
    }

    @Override
    public TblOrder selectByPk(String pk) {
        return orderMapper.selectByPrimaryKey(pk);
    }

    @Override
    public int delete(String pk) {
        return orderMapper.deleteByPrimaryKey(pk);
    }

    @Override
    public PageInfo<TblOrder> selectByConditionPage(TblOrder tblOrder, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return new PageInfo<>(orderMapper.selectByCondition(tblOrder));
    }

    @Override
    public int order(String customerUuid, List<TblCart> list) {
        for (TblCart cart : list) {
            TblOrder tblOrder = new TblOrder();
            tblOrder.setCustomerUuid(customerUuid);
            tblOrder.setOrderTime(String.valueOf(System.currentTimeMillis()));
            insert(tblOrder);
        }
        return 0;
    }
}
