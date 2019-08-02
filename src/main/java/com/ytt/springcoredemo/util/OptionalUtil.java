package com.ytt.springcoredemo.util;

import java.util.Optional;
import java.util.function.Function;

/**
 * @Author: aaron
 * @Descriotion:
 * @Date: 0:04 2019/8/2
 * @Modiflid By:
 */
public class OptionalUtil {

    public static  <T, K> K getTarget(Optional<T> optional, Function<T,K> target){
        return optional.isPresent() ? optional.map(target).orElseGet(() -> null) : null;
    }

}
