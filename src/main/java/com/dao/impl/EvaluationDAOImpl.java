package com.dao.impl;

import com.dao.EvaluationDAO;
import com.dao.mapper.EvaluationMapper;
import com.entity.Evaluation;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by ZhenXi on 2016/1/13.
 */
@Component("evaluationDAO")
public class EvaluationDAOImpl extends BaseDAO implements EvaluationDAO {

    @Resource
    private EvaluationMapper evaluationMapper;

    @Override
    String getTableName() {
        return "evaluation";
    }

    @Override
    public Long addEvaluation(Evaluation evaluation) {
        evaluation.setEvaluationId(getSequence());
        return evaluationMapper.addEvaluation(evaluation) == 0 ? 0l : evaluation.getEvaluationId();
    }

    @Override
    public List<Evaluation> getEvaluationByBookId(Long bookId, Integer cursor, Integer offset) {
        return evaluationMapper.getEvaluationByBookId(bookId, cursor, offset);
    }

    @Override
    public Long delEvaluation(Long evaluationId) {
        return evaluationMapper.delEvaluation(evaluationId) == 0 ? 0l : evaluationId;
    }

    @Override
    public List<Evaluation> getEvaluationByUserId(Long userId, Integer cursor, Integer offset) {
        return evaluationMapper.getEvaluationByUserId(userId, cursor, offset);
    }
}
