package com.entity;

import java.util.Date;

/**
 * Created by ZhenXi on 2016/1/11.
 */
public class Category {
    private Long categoryId;

    //类别名
    private String name;

    private Date createDate;

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
