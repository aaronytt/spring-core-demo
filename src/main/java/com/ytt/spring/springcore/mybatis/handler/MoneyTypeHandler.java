package com.ytt.spring.springcore.mybatis.handler;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;

import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
        if(parameter == null){
            ps.setBigDecimal(i,null);
        }else {
            ps.setBigDecimal(i,parameter.getAmount());
        }
    }

    @Override
    public Money getNullableResult(ResultSet rs, String columnName) throws SQLException {
        BigDecimal result = rs.getBigDecimal(columnName);
        return null == result ? null : Money.of(CurrencyUnit.of("CNY"), rs.getBigDecimal(columnName).setScale(2));
    }

    @Override
    public Money getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        BigDecimal result = rs.getBigDecimal(columnIndex);
        return null == result ? null : Money.of(CurrencyUnit.of("CNY"), rs.getBigDecimal(columnIndex).setScale(2));
    }

    @Override
    public Money getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        BigDecimal result = cs.getBigDecimal(columnIndex);
        return null == result ? null : Money.of(CurrencyUnit.of("CNY"), cs.getBigDecimal(columnIndex).setScale(2));
    }

}
