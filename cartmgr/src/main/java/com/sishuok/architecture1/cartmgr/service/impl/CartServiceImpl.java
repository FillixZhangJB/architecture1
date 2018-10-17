package com.sishuok.architecture1.cartmgr.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sishuok.architecture1.cartmgr.dao.TblCartMapper;
import com.sishuok.architecture1.cartmgr.service.CartService;
import com.sishuok.architecture1.cartmgr.vo.TblCart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by zjb on 2018/10/17.
 */
@Service
@Transactional
public class CartServiceImpl implements CartService {
    @Autowired
    TblCartMapper cartMapper;

    @Override
    public int insert(TblCart tblCart) {
        return cartMapper.insert(tblCart);
    }

    @Override
    public PageInfo<TblCart> selectAllByPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<TblCart> tblCarts = cartMapper.selectAll();
        PageInfo<TblCart> tblCartPageInfo = new PageInfo<>(tblCarts);
        return tblCartPageInfo;
    }

    @Override
    public int updateWithVersion(TblCart tblCart) {
        return cartMapper.updateByPrimaryKeyWithVersion(tblCart);
    }

    @Override
    public TblCart selectByPk(String pk) {
        return cartMapper.selectByPrimaryKey(pk);
    }


    @Override
    public int delete(String pk) {
        return cartMapper.deleteByPrimaryKey(pk);
    }

    @Override
    public PageInfo<TblCart> selectByConditionPage(TblCart tblCart, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<TblCart> cartList = cartMapper.selectByCondition(tblCart);
        PageInfo<TblCart> tblCartPageInfo = new PageInfo<>(cartList);
        return tblCartPageInfo;
    }

}
