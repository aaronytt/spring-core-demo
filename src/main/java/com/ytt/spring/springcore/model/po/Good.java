package com.ytt.spring.springcore.model.po;

import com.ytt.spring.springcore.model.BaseEntity;
import lombok.*;
import org.joda.money.Money;

import java.io.Serializable;

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
public class Good extends BaseEntity<Long> implements Serializable {

    private String name;

    private Money price;

}
