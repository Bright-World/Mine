package com.dao.impl;

import com.dao.CategoryDAO;
import com.dao.mapper.CategoryMapper;
import com.entity.Category;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by ZhenXi on 2016/1/13.
 */
@Component("categoryDAO")
public class CategoryDAOImpl extends BaseDAO implements CategoryDAO {

    @Resource
    private CategoryMapper categoryMapper;

    @Override
    String getTableName() {
        return "category";
    }

    @Override
    public Long addCategory(Category category) {
        category.setCategoryId(getSequence());
        return categoryMapper.addCategory(category) == 0 ? 0l : category.getCategoryId();
    }

    @Override
    public Long delCategory(Long categoryId) {
        return categoryMapper.delCategory(categoryId) == 0 ? 0l : categoryId;
    }

    @Override
    public List<Category> getCategories() {
        return categoryMapper.getCategories();
    }

    @Override
    public Category getCategoryById(Long categoryId) {
        return categoryMapper.getCategoryById(categoryId);
    }
}
