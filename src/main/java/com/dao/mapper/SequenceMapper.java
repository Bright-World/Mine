package com.dao.mapper;

import org.apache.ibatis.annotations.Select;

/**
 * Created by ZhenXi on 2016/1/11.
 */
public interface SequenceMapper {

    @Select("select curval from sequence where table_name = #{tableName}")
    public Long getSequence(String tableName);

    @Select("update sequence set curval = curval + increment where table_name = #{tableName}")
    public void updateSequence(String tableName);
}
