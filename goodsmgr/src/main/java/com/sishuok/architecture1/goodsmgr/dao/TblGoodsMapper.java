package com.sishuok.architecture1.goodsmgr.dao;

import com.sishuok.architecture1.common.basedao.MyBaseMapper;
import com.sishuok.architecture1.goodsmgr.vo.TblGoods;

import java.util.List;

public interface TblGoodsMapper extends MyBaseMapper<TblGoods> {

    List<TblGoods> selectByCondition(TblGoods goods);
}