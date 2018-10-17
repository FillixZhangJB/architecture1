package com.sishuok.architecture1.cartmgr.dao;

import com.sishuok.architecture1.cartmgr.vo.TblCart;
import com.sishuok.architecture1.common.basedao.MyBaseMapper;

import java.util.List;

public interface TblCartMapper extends MyBaseMapper<TblCart> {
    List<TblCart> selectByCondition(TblCart tblCart);
}