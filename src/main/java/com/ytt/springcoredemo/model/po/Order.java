package com.ytt.springcoredemo.model.po;

import com.ytt.springcoredemo.model.BaseEntity;
import com.ytt.springcoredemo.model.enumeration.OrderState;
import lombok.*;

import java.io.Serializable;
import java.util.List;

/**
 * @Author: aaron
 * @Descriotion:
 * @Date: 18:14 2019/4/26
 * @Modiflid By:
 */
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode
public class Order extends BaseEntity<Long> implements Serializable {

    private Long customerId;

    private String customer;

    private OrderState state;

    private List<Good> goodsList;

}
