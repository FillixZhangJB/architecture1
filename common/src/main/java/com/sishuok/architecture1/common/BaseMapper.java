package com.sishuok.architecture1.common;

import java.util.List;

/**
 * Created by zjb on 2018/9/21.
 */
public interface BaseMapper<M, QM> {
    void create(M m);

    void update(M m);

    void delete(int uuid);

    M getByUuid(int uuid);

    List<M> getByConditionByPage(QM qm);


}
