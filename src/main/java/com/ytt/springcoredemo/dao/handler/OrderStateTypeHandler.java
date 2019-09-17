package com.ytt.springcoredemo.dao.handler;

import com.ytt.springcoredemo.model.enumeration.OrderState;
import com.ytt.springcoredemo.util.OptionalUtil;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

/**
 * @Author: aaron
 * @Descriotion:
 * @Date: 13:21 2019/6/20
 * @Modiflid By:
 */
@MappedTypes({OrderState.class})
public class OrderStateTypeHandler extends BaseTypeHandler<OrderState> {

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, OrderState parameter, JdbcType jdbcType) throws SQLException {
        ps.setByte(i,Optional.ofNullable(parameter.getState()).orElseGet(() -> null));
    }

    @Override
    public OrderState getNullableResult(ResultSet rs, String columnName) throws SQLException {
       return OptionalUtil.getTarget(
               Optional.of(rs.getByte(columnName)),
               result -> OrderState.getOrderStateByState(result)
       );
    }

    @Override
    public OrderState getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return OptionalUtil.getTarget(
                Optional.of(rs.getByte(columnIndex)),
                result -> OrderState.getOrderStateByState(result)
        );
    }

    @Override
    public OrderState getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return OptionalUtil.getTarget(
                Optional.of(cs.getByte(columnIndex)),
                result -> OrderState.getOrderStateByState(result)
        );
    }

}
