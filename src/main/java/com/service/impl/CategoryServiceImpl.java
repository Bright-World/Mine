package com.service.impl;

import com.dao.CategoryDAO;
import com.entity.Category;
import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.response.CategoryResponse;
import com.response.Result;
import com.service.CategoryService;
import com.utils.ConvertUtils;
import com.utils.ErrorCodeEnum;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by ZhenXi on 2016/1/15.
 */
@Component("categoryService")
public class CategoryServiceImpl implements CategoryService {

    @Resource
    private CategoryDAO categoryDAO;

    @Override
    public Result addCategory(Category category) {
        Long categoryId = categoryDAO.addCategory(category);
        if (categoryId == 0) {
            return new Result(ErrorCodeEnum.ADD_ERROR);
        }
        return new Result(categoryId);
    }

    @Override
    public Result delCategory(Long categoryId) {
        if (categoryDAO.delCategory(categoryId) == 0) {
            return new Result(ErrorCodeEnum.DELETE_ERROR);
        }
        return new Result(categoryId);
    }

    @Override
    public Result<List<CategoryResponse>> getCategories() {
        return new Result<>(Lists.transform(categoryDAO.getCategories(), new Function<Category, CategoryResponse>() {
            @Override
            public CategoryResponse apply(Category category) {
                return ConvertUtils.convert(category);
            }
        }));
    }
}
