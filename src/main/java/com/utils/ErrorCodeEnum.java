package com.utils;

/**
 * Created by ZhenXi on 2016/1/14.
 */
public enum ErrorCodeEnum {

    ADD_ERROR(9001, "添加错误"),
    UPDATE_ERROR(9002, "更新出错"),
    DELETE_ERROR(9003, "删除出错"),

    NO_USER(1001, "用户名密码错误"),
    EXIST_USER(1002, "用户已存在"),

    OUT_OF_NUM(2001, "超出数量限制"),

    ERROR_RES_TYPE(3001, "无效的资源类型");

    private Integer status;

    private String msg;

    private ErrorCodeEnum(int status, String msg) {
         this.status = status;
         this.msg = msg;
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
}
