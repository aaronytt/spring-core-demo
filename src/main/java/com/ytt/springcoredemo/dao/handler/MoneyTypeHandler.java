package com.ytt.springcoredemo.dao.handler;

import com.ytt.springcoredemo.util.OptionalUtil;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;

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
@MappedTypes({Money.class})
public class MoneyTypeHandler extends BaseTypeHandler<Money> {

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, Money parameter, JdbcType jdbcType) throws SQLException {
        ps.setBigDecimal(i,Optional.ofNullable(parameter.getAmount()).orElseGet(() -> null));
    }

    @Override
    public Money getNullableResult(ResultSet rs, String columnName) throws SQLException {
        return OptionalUtil.getTarget(
                Optional.of(rs.getBigDecimal(columnName)),
                result -> Money.of(CurrencyUnit.of("CNY"), result.setScale(2))
        );
    }

    @Override
    public Money getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return OptionalUtil.getTarget(
                Optional.of(rs.getBigDecimal(columnIndex)),
                result -> Money.of(CurrencyUnit.of("CNY"), result.setScale(2))
        );
    }

    @Override
    public Money getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return OptionalUtil.getTarget(
                Optional.of(cs.getBigDecimal(columnIndex)),
                result -> Money.of(CurrencyUnit.of("CNY"), result.setScale(2))
        );
    }

}
