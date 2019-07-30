package com.ytt.spring.springcore.model.po;

import com.ytt.spring.springcore.model.BaseEntity;
import lombok.*;

import java.io.Serializable;

/**
 * @Author: aaron
 * @Descriotion:
 * @Date: 0:37 2019/3/8
 * @Modiflid By:
 */
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode
public class City extends BaseEntity<Integer> implements Serializable {

    private String name;

    private String state;

    private String country;

    private String cord;

}
