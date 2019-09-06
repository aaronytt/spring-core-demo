package com.ytt.springcoredemo.service.base;

import com.ytt.springcoredemo.model.BaseEntity;

/**
 * @Author: aaron
 * @Descriotion:
 * @Date: 3:48 2019/8/1
 * @Modiflid By:
 */
public interface CrudBaseService<T extends BaseEntity<ID>, ID>
        extends DeleteBaseService<T, ID>, FetchBaseService<T, ID>, SaveBaseService<T, ID>, UpdateBaseService<T, ID> {

//    @Override
//    default int deleteByID(ID id) {
//        return 0;
//    }
//
//    @Override
//    default T fetchByID(ID id) {
//        return null;
//    }
//
//    @Override
//    default List<T> fetchSelective(T record) {
//        return null;
//    }
//
//    @Override
//    default int save(T record) {
//        return 0;
//    }
//
//    @Override
//    default int saveSelective(T record) {
//        return 0;
//    }
//
//    @Override
//    default int updateByPrimaryKeySelective(T record) {
//        return 0;
//    }
//
//    @Override
//    default int updateByPrimaryKeyWithBLOBs(T record) {
//        return 0;
//    }
//
//    @Override
//    default int updateByPrimaryKey(ID id) {
//        return 0;
//    }

}
