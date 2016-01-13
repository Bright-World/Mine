package com.dao.mapper;

import com.entity.Category;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by ZhenXi on 2016/1/12.
 */
public interface CategoryMapper {

    final static String COLUMN_ALL = "category_id,name,create_date";

    @Insert("insert into category(" + COLUMN_ALL + ") values(#{categoryId},#{name},now())")
    int addCategory(Category category);

    @Delete("delete from category where category_id = #{categoryId}")
    int delCategory(Long categoryId);

    @Select("select * from category")
    @ResultMap("categoryMap")
    List<Category> getCategories();

    @Select("select * from category where category_id = #{categoryId}")
    @ResultMap("categoryMap")
    Category getCategoryById(Long categoryId);
}
