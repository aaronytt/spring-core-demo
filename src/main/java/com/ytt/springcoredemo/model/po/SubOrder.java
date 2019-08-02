package com.ytt.springcoredemo.model.po;

import com.ytt.springcoredemo.model.BaseEntity;
import com.ytt.springcoredemo.model.enumeration.OrderState;
import lombok.*;
import org.joda.money.Money;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode
public class SubOrder extends BaseEntity<Long> {

    private String orderNumber;

    private String subOrderNumber;

    private Money amount;

    private OrderState state;

    private Long goodId;

    private Integer quantity;

    private static final long serialVersionUID = 1L;
}