package com.sishuok.architecture1.common.baseservice;

import com.github.pagehelper.PageInfo;

/**
 * Created by zjb on 2018/9/28.
 */
public interface BaseService<T> {
    int insert(T t);

    PageInfo<T> selectAllByPage(int pageNum, int pageSize);

    int updateWithVersion(T t);

    T selectByPk(String pk);

    int delete(String pk);

    PageInfo<T> selectByConditionPage(T t, int pageNum, int pageSize);


}
