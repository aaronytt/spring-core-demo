package com.ytt.springcoredemo.model.po;

import com.ytt.springcoredemo.model.BaseEntity;
import com.ytt.springcoredemo.model.enumeration.OrderState;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode
public class Order extends BaseEntity<Long> {

    private String orderNumber;

    private Long customerId;

    private BigDecimal amount;

    private OrderState state;

    private List<SubOrder> subOrderList;

}