package com.ytt.springcoredemo.concurrent.pool.db;

import lombok.Builder;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @Author: aaron
 * @Descriotion:
 * @Date: 17:20 2019/8/16
 * @Modiflid By:
 */
@Builder
public class SqlConnectionImpl extends DefaultConnectionImpl {

    public final static Connection getSqlConnection(){
        return SqlConnectionImpl.builder().build();
    }

    @Override
    public Statement createStatement(int resultSetType, int resultSetConcurrency) throws SQLException {
        try {
            Thread.currentThread().sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void commit() throws SQLException {
        try {
            Thread.currentThread().sleep(70);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
