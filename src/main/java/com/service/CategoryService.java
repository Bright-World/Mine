package com.service;

import com.entity.Category;
import com.response.CategoryResponse;
import com.response.Result;

import java.util.List;

/**
 * Created by ZhenXi on 2016/1/15.
 */
public interface CategoryService {

    public Result addCategory(Category category);

    public Result delCategory(Long categoryId);

    public Result<List<CategoryResponse>> getCategories();
}
