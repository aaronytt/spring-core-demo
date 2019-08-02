package com.ytt.springcoredemo.model.po;

import com.ytt.springcoredemo.model.BaseEntity;
import com.ytt.springcoredemo.model.enumeration.OrderState;
import lombok.*;
import org.joda.money.Money;

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

    private Money amount;

    private OrderState state;

    private List<SubOrder> subOrderList;

}