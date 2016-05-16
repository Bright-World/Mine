package com.response;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.utils.ErrorCodeEnum;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;

/**
 * Created by ZhenXi on 2016/1/13.
 */
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class Result<T> implements Serializable {

    private Integer status = 1;

    private String msg;

    private T res;

    public Result(){}

    public Result(T res) {
        this.res = res;
    }

    public Result(ErrorCodeEnum errorCodeEnum){
        status = errorCodeEnum.getStatus();
        msg = errorCodeEnum.getMsg();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getRes() {
        return res;
    }

    public void setRes(T res) {
        this.res = res;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
}
