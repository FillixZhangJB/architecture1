package com.sishuok.architecture1.ordermgr.dao;

import com.sishuok.architecture1.common.basedao.MyBaseMapper;
import com.sishuok.architecture1.ordermgr.vo.TblOrder;

import java.util.List;

public interface TblOrderMapper extends MyBaseMapper<TblOrder> {
    List<TblOrder> selectByCondition(TblOrder tblOrder);
}