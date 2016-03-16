package com.dao.mapper;

import com.entity.Evaluation;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by ZhenXi on 2016/1/12.
 */
public interface EvaluationMapper {

    final static String COLUMN_ALL = "evaluation_id,user_id,book_id,context,create_date";

    @Select("select * from evaluation where book_id = #{bookId} order by create_date desc limit #{cursor}, #{offset}")
    @ResultMap("evaluationMap")
    List<Evaluation> getEvaluationByBookId(@Param("bookId")Long bookId, @Param("cursor")Integer cursor, @Param("offset")Integer offset);

    @Select("select * from evaluation where user_id = #{userId} order by create_date desc limit #{cursor}, #{offset}")
    @ResultMap("evaluationMap")
    List<Evaluation> getEvaluationByUserId(@Param("userId")Long bookId, @Param("cursor")Integer cursor, @Param("offset")Integer offset);

    @Insert("insert into evaluation(" + COLUMN_ALL + ") values(#{evaluationId},#{userId},#{bookId},#{context},now())")
    int addEvaluation(Evaluation evaluation);

    @Delete("delete from evaluation where evaluation_id = #{evaluationId}")
    int delEvaluation(Long evaluationId);
}
