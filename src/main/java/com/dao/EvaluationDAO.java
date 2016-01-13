package com.dao;

import com.entity.Evaluation;

import java.util.List;

/**
 * Created by ZhenXi on 2016/1/13.
 */
public interface EvaluationDAO {

    public Long addEvaluation(Evaluation evaluation);

    public List<Evaluation> getEvaluationByBookId(Long bookId, Integer cursor, Integer offset);

    public List<Evaluation> getEvaluationByUserId(Long userId, Integer cursor, Integer offset);

    public Long delEvaluation(Long evaluationId);
}
