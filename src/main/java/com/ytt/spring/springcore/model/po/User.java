package com.ytt.spring.springcore.model.po;

import com.ytt.spring.springcore.model.BaseEntity;
import lombok.*;

import java.io.Serializable;

/**
 * @Author: aaron
 * @Descriotion:
 * @Date: 22:57 2019/7/27
 * @Modiflid By:
 */
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class User extends BaseEntity<Long> implements Serializable {

    private String username;

    private String password;

    private int age;

}
