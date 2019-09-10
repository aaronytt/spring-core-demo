package com.ytt.springcoredemo.model.po;

import com.ytt.springcoredemo.model.BaseEntity;
import lombok.*;

/**
 * @Author: aaron
 * @Descriotion:
 * @Date: 16:54 2019/9/6
 * @Modiflid By:
 */
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode
public class Article extends BaseEntity<Long> {

//    private String key;

    private String code;

    private String title;

    private String content;

    private String link;

    private Long userId;

}
