package com.sishuok.architecture1.goodsmgr.service;

import com.github.pagehelper.PageInfo;
import com.sishuok.architecture1.goodsmgr.vo.TblGoods;

/**
 * Created by zjb on 2018/10/15.
 */
public interface GoodsService {
    int insert(TblGoods tblGoods);

    int update(TblGoods customerModel);

    int delete(String pk);

    TblGoods selectByPk(String pk);

    PageInfo<TblGoods> selectByConditionPage(TblGoods cqm);

}
