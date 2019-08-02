package com.ytt.springcoredemo.model.po;


import com.ytt.springcoredemo.model.BaseEntity;
import lombok.*;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode
public class Area extends BaseEntity<Integer> {

    /**
    * 名称
    */
    private String name;

    /**
    * 层级标识： 1  省份， 2  市， 3  区县
    */
    private Byte level;

    /**
    * 父节点
    */
    private Integer parentId;

}