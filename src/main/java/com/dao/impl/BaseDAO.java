package com.dao.impl;

import com.dao.mapper.SequenceMapper;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by ZhenXi on 2016/1/11.
 */
public abstract class BaseDAO {

    @Resource
    private SequenceMapper sequenceMapper;

    @Transactional
    protected Long getSequence(){
        sequenceMapper.updateSequence(getTableName());
        return sequenceMapper.getSequence(getTableName());
    }

    protected abstract String getTableName();
}
