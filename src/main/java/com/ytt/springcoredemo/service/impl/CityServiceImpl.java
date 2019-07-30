package com.ytt.springcoredemo.service.impl;

import com.ytt.springcoredemo.service.CityService;
import com.ytt.springcoredemo.model.po.City;
import com.ytt.springcoredemo.mybatis.mapper.CityMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @Author: aaron
 * @Descriotion:
 * @Date: 23:01 2019/7/27
 * @Modiflid By:
 */
@Service
@Slf4j
public class CityServiceImpl extends BaseServiceImpl<City,Integer, CityMapper> implements CityService {
}
