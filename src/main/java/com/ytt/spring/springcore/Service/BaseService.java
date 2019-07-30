package com.ytt.spring.springcore.Service;

import com.ytt.spring.springcore.model.BaseEntity;
import com.ytt.spring.springcore.mybatis.mapper.BaseMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

/**
 * @Author: aaron
 * @Descriotion:
 * @Date: 0:07 2019/7/31
 * @Modiflid By:
 */
public interface BaseService<T extends BaseEntity<ID>, ID extends Serializable> {

    T insert(T record);

    T insertSelective(T record);

    int deleteByPrimaryKey(ID id);

    T selectByPrimaryKey(ID id);

    List<T> selectSelective(T record);

    int updateByPrimaryKeySelective(T record);

    int updateByPrimaryKeyWithBLOBs(T record);

    int updateByPrimaryKey(ID id);

}
