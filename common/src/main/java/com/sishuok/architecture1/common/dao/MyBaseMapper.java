package com.sishuok.architecture1.common.dao;

import tk.mybatis.mapper.common.Mapper;

/**
 * Created by zjb on 2018/9/27.
 */
public interface MyBaseMapper<T> extends Mapper<T> {
    default int deleteWithVersion(T t) {
        int result = delete(t);
        if (result == 0) {
            throw new RuntimeException("删除失败");
        }
        return result;
    }

    default int deleteByPrimaryKeyWithVersion(T t) {
        int result = deleteByPrimaryKey(t);
        if (result == 0) {
            throw new RuntimeException("删除失败");
        }
        return result;
    }

    default int updateByPrimaryKeyWithVersion(T t) {
        int result = updateByPrimaryKey(t);
        if (result == 0) {
            throw new RuntimeException("删除失败");
        }
        return result;
    }

    default int updateByPrimaryKeySelectiveWithVersion(T t) {
        int result = updateByPrimaryKeySelective(t);
        if (result == 0) {
            throw new RuntimeException("删除失败");
        }
        return result;
    }

}