package com.response;

import java.util.Date;

/**
 * Created by ZhenXi on 2016/1/15.
 */
public class CategoryResponse {

    private Long categoryId;

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
