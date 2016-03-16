package com.service.impl;

import com.dao.BookDAO;
import com.dao.EvaluationDAO;
import com.dao.UserDAO;
import com.entity.Evaluation;
import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.response.EvaluationResponse;
import com.response.Result;
import com.service.EvaluationService;
import com.utils.ConvertUtils;
import com.utils.ErrorCodeEnum;
import com.utils.PageUtils;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by ZhenXi on 2016/1/15.
 */
@Component("evaluationService")
public class EvaluationServiceImpl implements EvaluationService {

    @Resource
    private EvaluationDAO evaluationDAO;

    @Resource
    private UserDAO userDAO;

    @Resource
    private BookDAO bookDAO;

    @Override
    @Transactional
    public Result addEvaluation(Evaluation evaluation) {
        Long evaluationId = evaluationDAO.addEvaluation(evaluation);
        if (evaluationId == 0) {
            return new Result(ErrorCodeEnum.ADD_ERROR);
        }
        return new Result(evaluationId);
    }

    @Override
    public Result<List<EvaluationResponse>> getEvaluationByBookId(Long bookId, Integer page) {
        return new Result<>(Lists.transform(evaluationDAO.getEvaluationByBookId(bookId, PageUtils.getCursor(page), PageUtils.offset), new Function<Evaluation, EvaluationResponse>() {
            @Override
            public EvaluationResponse apply(Evaluation evaluation) {
                EvaluationResponse evaluationResponse = ConvertUtils.convert(evaluation);
                evaluationResponse.setNick(userDAO.getUserById(evaluation.getUserId()).getNick());
                evaluationResponse.setBookName(bookDAO.getBookById(evaluation.getBookId()).getName());
                return evaluationResponse;
            }
        }));
    }

    @Override
    public Result<List<EvaluationResponse>> getEvaluationByUserId(Long userId, Integer page) {
        return new Result<>(Lists.transform(evaluationDAO.getEvaluationByUserId(userId, PageUtils.getCursor(page), PageUtils.offset), new Function<Evaluation, EvaluationResponse>() {
            @Override
            public EvaluationResponse apply(Evaluation evaluation) {
                EvaluationResponse evaluationResponse = ConvertUtils.convert(evaluation);
                evaluationResponse.setNick(userDAO.getUserById(evaluation.getUserId()).getNick());
                evaluationResponse.setBookName(bookDAO.getBookById(evaluation.getBookId()).getName());
                return evaluationResponse;
            }
        }));
    }

    @Override
    public Result delEvaluation(Long evaluationId) {
        if (evaluationDAO.delEvaluation(evaluationId) == 0) {
            return new Result(ErrorCodeEnum.DELETE_ERROR);
        }
        return new Result(evaluationId);
    }
}
