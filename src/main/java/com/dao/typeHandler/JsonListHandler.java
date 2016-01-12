package com.dao.typeHandler;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Strings;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by ZhenXi on 2016/1/11.
 */
public class JsonListHandler extends BaseTypeHandler<List<String>> {

    private static TypeReference<List<String>> type = new TypeReference<List<String>>() {};
    private static ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, List<String> strings, JdbcType jdbcType) throws SQLException {
        if(strings == null){
            preparedStatement.setString(i, null);
        }
        String value;
        try{
            value = objectMapper.writeValueAsString(strings);
        } catch (Exception e){
            throw new RuntimeException("JsonObject互转异常");
        }
        preparedStatement.setString(i, value);
    }

    @Override
    public List<String> getNullableResult(ResultSet resultSet, String s) throws SQLException {
        String json = resultSet.getString(s);
        return toList(json);
    }

    @Override
    public List<String> getNullableResult(ResultSet resultSet, int i) throws SQLException {
        String json = resultSet.getString(i);
        return toList(json);
    }

    @Override
    public List<String> getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        String json = callableStatement.getString(i);
        return toList(json);
    }

    private List<String> toList(String json){
        if(Strings.isNullOrEmpty(json)){
            return null;
        }
        try{
            List<String> result = objectMapper.readValue(json, type);
            return result;
        } catch (Exception e){
            throw new RuntimeException("JsonObject互转异常");
        }
    }
}
