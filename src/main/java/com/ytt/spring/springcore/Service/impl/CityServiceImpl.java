package com.ytt.spring.springcore.Service.impl;

import com.ytt.spring.springcore.Service.CityService;
import com.ytt.spring.springcore.model.po.City;
import com.ytt.spring.springcore.mybatis.mapper.CityMapper;
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
public class CityServiceImpl extends BaseServiceImpl<City,Integer,CityMapper> implements CityService {
}
