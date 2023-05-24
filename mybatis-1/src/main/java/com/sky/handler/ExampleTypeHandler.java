package com.sky.handler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

public class ExampleTypeHandler implements TypeHandler<String> {

  @Override
  public void setParameter(PreparedStatement preparedStatement, int i, String s, JdbcType jdbcType)
      throws SQLException {

  }

  @Override
  public String getResult(ResultSet resultSet, String s) throws SQLException {
    return null;
  }

  @Override
  public String getResult(ResultSet resultSet, int i) throws SQLException {
    return null;
  }

  @Override
  public String getResult(CallableStatement callableStatement, int i) throws SQLException {
    return null;
  }
}
