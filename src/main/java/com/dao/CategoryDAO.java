package com.dao;

import com.entity.Category;

import java.util.List;

/**
 * Created by ZhenXi on 2016/1/13.
 */
public interface CategoryDAO {

    public Long addCategory(Category category);

    public Long delCategory(Long categoryId);

    public List<Category> getCategories();

    public Category getCategoryById(Long categoryId);
}
