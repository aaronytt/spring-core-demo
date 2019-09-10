package com.ytt.springcoredemo.model.po;

import com.ytt.springcoredemo.model.BaseEntity;
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
public class User extends BaseEntity<Long> {

    private String username;

    private String password;

    private Byte sex;

    private Byte age;

}
