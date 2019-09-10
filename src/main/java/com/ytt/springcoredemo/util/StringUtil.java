package com.ytt.springcoredemo.util;

import java.util.Arrays;

/**
 * @Author: aaron
 * @Descriotion:
 * @Date: 3:14 2019/3/12
 * @Modiflid By:
 */
public class StringUtil {

    public static String combine(Object... obs ){

        StringBuilder builder = new StringBuilder();

        Arrays.asList(obs).stream().map(o -> o.toString()).forEach(
                s -> {
                    builder.append(s);
                }
        );

        return builder.toString();

    }

}
