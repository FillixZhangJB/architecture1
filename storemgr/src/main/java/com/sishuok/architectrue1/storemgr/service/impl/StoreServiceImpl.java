package com.sishuok.architectrue1.storemgr.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sishuok.architectrue1.storemgr.dao.TblStoreMapper;
import com.sishuok.architectrue1.storemgr.service.StoreService;
import com.sishuok.architectrue1.storemgr.vo.TblStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.jws.soap.SOAPBinding;
import java.util.List;

/**
 * Created by zjb on 2018/10/18.
 */
@Service
@Transactional
public class StoreServiceImpl implements StoreService {
    @Autowired
    TblStoreMapper storeMapper;

    @Override
    public int insert(TblStore tblStore) {
        return storeMapper.insert(tblStore);
    }

    @Override
    public PageInfo<TblStore> selectAllByPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<TblStore> tblStores = storeMapper.selectAll();
        PageInfo<TblStore> tblStorePageInfo = new PageInfo<>(tblStores);
        return tblStorePageInfo;
    }

    @Override
    public int updateWithVersion(TblStore tblStore) {
        return storeMapper.updateByPrimaryKeyWithVersion(tblStore);
    }

    @Override
    public TblStore selectByPk(String pk) {
        return storeMapper.selectByPrimaryKey(pk);
    }

    @Override
    public int delete(String pk) {
        return storeMapper.deleteByPrimaryKey(pk);
    }

    @Override
    public PageInfo<TblStore> selectByConditionPage(TblStore tblStore, int pageNum, int pageSize) {
        PageHelper.startPage(pageSize, pageNum);
        List<TblStore> storeList = storeMapper.selectByCondition(tblStore);
        PageInfo<TblStore> tblStorePageInfo = new PageInfo<>(storeList);
        return tblStorePageInfo;
    }
}
