package com.ytt.springcoredemo.model.po;

import com.ytt.springcoredemo.model.BaseEntity;
import lombok.*;
import org.joda.money.Money;

import java.io.Serializable;
import java.math.BigDecimal;

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
public class Good extends BaseEntity<Long> {

    private String name;

    private BigDecimal price;

}
