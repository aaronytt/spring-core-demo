//package com.ytt.springcoredemo.service;
//
//import com.ytt.springcoredemo.model.po.Order;
//import com.ytt.springcoredemo.redis.util.JedisUtil;
//import com.ytt.springcoredemo.service.RedisOrderService;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.time.ZoneOffset;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.stream.Collectors;
//
///**
// * @Author: aaron
// * @Descriotion:
// * @Date: 18:24 2019/9/7
// * @Modiflid By:
// */
//@Service
//@Slf4j
//public class RedisOrderServiceImpl implements RedisOrderService {
//
//    String ORDER_PRE_CACHE = "order:pre:cache";
//    String ORDER_PREFIX = "order:";
//    String ORDER_LIST = "oreder:list";
//    String USER_ORDER = "user:order:";
//    private final static int PRE_PAGE = 5;
//
//    @Autowired
//    private JedisUtil jedisUtil;
//
//    @Override
//    public String postOrder(Order order) {
//        //封装数据
//        Map<String,String> orderMap = new HashMap<>();
//        orderMap.put("orderNumber",order.getOrderNumber());
//        orderMap.put("customerId",String.valueOf(order.getCustomerId()));
//        orderMap.put("amount",order.getAmount().toString());
//        orderMap.put("state",String.valueOf(order.getState().getState()));
//        orderMap.put("createTime",String.valueOf(order.getCreateTime().toInstant(ZoneOffset.of("+8")).toEpochMilli()/1000));
//        orderMap.put("subOrderIds",order.getSubOrderList().parallelStream().map(subOrder -> subOrder.getSubOrderNumber()).reduce("", (subOrderNumber1,subOrderNumber2) -> subOrderNumber1+ ":" + subOrderNumber2));
//
//        //生成orderkey
//        String orderkey = ORDER_PREFIX + order.getOrderNumber();
//        String userOrderKey = USER_ORDER + String.valueOf(order.getCustomerId());
//        try {
//            //检验缓存中未处理的订单，防重复
//            if(jedisUtil.sadd(ORDER_PRE_CACHE, orderkey) > 0) {
//                //1.订单存入hash,以便于修改
//                jedisUtil.hmset(orderkey, orderMap, 0);
//                //2.订单放入订单队列,等待处理(处理完成记得清理缓存订单号,把id填上)
//                jedisUtil.lpush(0,ORDER_LIST, orderkey);
//                //3.订单对应到到用户
//                jedisUtil.zadd(userOrderKey, Double.valueOf(orderMap.get("createTime")), orderkey);
//            }
//
//            return order.getOrderNumber();
//        } catch (Exception e) {
//            log.error(e.getMessage());
//        }
//        return null;
//    }
//
//    @Override
//    public List<Map<String, String>> getOrdersByCustomerId(int page, String customerId) {
//        int start = (page - 1) * PRE_PAGE;
//        int end = start + PRE_PAGE - 1;
//        String userOrderKey = USER_ORDER + customerId;
//
//        return jedisUtil.zrevrange(userOrderKey, start, end)
//                .parallelStream()
//                .map(orderkey -> jedisUtil.hgetall(orderkey, 0))
//                .collect(Collectors.toList());
//    }
//
//    @Override
//    public Map<String, String> getOrderByOrderNumber(String orderNumber) {
//        return  jedisUtil.hgetall(orderNumber, 0);
//    }
//
//}
