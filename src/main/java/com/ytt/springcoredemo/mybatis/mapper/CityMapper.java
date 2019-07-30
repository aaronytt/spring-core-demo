package com.ytt.springcoredemo.mybatis.mapper;

/**
 * @Author: aaron
 * @Descriotion:
 * @Date: 0:38 2019/3/8
 * @Modiflid By:
 */

import com.ytt.springcoredemo.model.po.City;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface CityMapper extends BaseMapper<City, Integer> {

    @Override
    @Insert("INSERT INTO city (name, state, country) VALUES(#{name}, #{state}, #{country})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(City city);

    @Override
    @Select("SELECT id, name, state, country FROM city WHERE id = #{id}")
    City selectByPrimaryKey(Integer id);

}
