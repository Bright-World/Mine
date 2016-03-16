package com.service;

import com.entity.Evaluation;
import com.response.EvaluationResponse;
import com.response.Result;

import java.util.List;

/**
 * Created by ZhenXi on 2016/1/15.
 */
public interface EvaluationService {

    public Result addEvaluation(Evaluation evaluation);

    public Result<List<EvaluationResponse>> getEvaluationByBookId(Long bookId, Integer page);

    public Result<List<EvaluationResponse>> getEvaluationByUserId(Long userId, Integer page);

    public Result delEvaluation(Long evaluationId);
}
