package com.sishuok.architectrue1.storemgr.dao;

import com.sishuok.architectrue1.storemgr.vo.TblStore;
import com.sishuok.architecture1.common.basedao.MyBaseMapper;

import java.util.List;

public interface TblStoreMapper extends MyBaseMapper<TblStore> {
    List<TblStore> selectByCondition(TblStore tblStore);
}