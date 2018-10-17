package com.sishuok.architecture1.goodsmgr.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sishuok.architecture1.goodsmgr.dao.TblGoodsMapper;
import com.sishuok.architecture1.goodsmgr.service.GoodsService;
import com.sishuok.architecture1.goodsmgr.vo.TblGoods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by zjb on 2018/10/15.
 */
@Service
@Transactional
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    private TblGoodsMapper goodsMapper;

    @Override
    public int insert(TblGoods tblGoods) {
        return goodsMapper.insert(tblGoods);
    }

    @Override
    public int update(TblGoods goods) {
        return goodsMapper.updateByPrimaryKey(goods);
    }

    @Override
    public TblGoods selectByPk(String pk) {
        return goodsMapper.selectByPrimaryKey(pk);
    }

    @Override
    public int delete(String pk) {
        return goodsMapper.deleteByPrimaryKey(pk);
    }

    @Override
    public PageInfo<TblGoods> selectByConditionPage(TblGoods goods) {
        PageHelper.startPage(1, 20);
        List<TblGoods> goodss = goodsMapper.selectByCondition(goods);
        PageInfo<TblGoods> goodsQueryModelPageInfo = new PageInfo<TblGoods>(goodss);
        return goodsQueryModelPageInfo;
    }

}
