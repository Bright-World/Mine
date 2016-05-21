package com.service.impl;

import com.dao.BookDAO;
import com.dao.EvaluationDAO;
import com.dao.UserDAO;
import com.entity.Book;
import com.entity.Evaluation;
import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.response.BookResponse;
import com.response.EvaluationResponse;
import com.response.Result;
import com.service.BookService;
import com.utils.ConvertUtils;
import com.utils.ErrorCodeEnum;
import com.utils.PageUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by ZhenXi on 2016/1/13.
 */
@Component("bookService")
public class BookServiceImpl implements BookService {

    @Resource
    private BookDAO bookDAO;

    @Resource
    private EvaluationDAO evaluationDAO;

    @Resource
    private UserDAO userDAO;

    @Override
    public Result addBook(Book book) {
        Long bookId = bookDAO.addBook(book);
        if(bookId == 0) {
            return new Result<>(ErrorCodeEnum.ADD_ERROR);
        }
        return new Result(bookId);
    }

    @Override
    public Result<Long> updateBook(Book book) {
        Long bookId = bookDAO.updateBook(book);
        if(bookId == 0) {
            return new Result<>(ErrorCodeEnum.UPDATE_ERROR);
        }
        return new Result(bookId);
    }

    @Override
    public Result<List<BookResponse>> getBooksOrderByModifiedDate(Integer page) {
        return new Result<>(Lists.transform(bookDAO.getBooksOrderByBorrowNum(PageUtils.getCursor(page), PageUtils.offset), new Function<Book, BookResponse>() {
            @Override
            public BookResponse apply(Book book) {
                return ConvertUtils.convert(book);
            }
        }));
    }

    @Override
    public Result<List<BookResponse>> getBooksOrderByBorrowNum(Integer page) {
        return new Result<>(Lists.transform(bookDAO.getBooksOrderByBorrowNum(PageUtils.getCursor(page), PageUtils.offset), new Function<Book, BookResponse>() {
            @Override
            public BookResponse apply(Book book) {
                return ConvertUtils.convert(book);
            }
        }));
    }

    @Override
    public Result<BookResponse> getBookById(Long bookId) {
        BookResponse bookResponse = ConvertUtils.convert(bookDAO.getBookById(bookId));
        List<Evaluation> evaluations = evaluationDAO.getEvaluationByBookId(bookId, 0, PageUtils.offset);
        if(!CollectionUtils.isEmpty(evaluations)) {
            bookResponse.setEvaluations(Lists.transform(evaluationDAO.getEvaluationByBookId(bookId, 0, PageUtils.offset), new Function<Evaluation, EvaluationResponse>() {
                @Override
                public EvaluationResponse apply(Evaluation evaluation) {
                    EvaluationResponse evaluationResponse = ConvertUtils.convert(evaluation);
                    evaluationResponse.setNick(userDAO.getUserById(evaluation.getUserId()).getNick());
                    evaluationResponse.setBookName(bookDAO.getBookById(evaluation.getBookId()).getName());
                    return evaluationResponse;
                }
            }));
        }
        return new Result<>(bookResponse);
    }

    @Override
    public Result delBook(Long bookId) {
        if (bookDAO.delBook(bookId) == 0) {
            return new Result(ErrorCodeEnum.DELETE_ERROR);
        }
        return new Result(bookId);
    }

    @Override
    public Result<List<BookResponse>> searchBook(Integer flag, String key, Integer page, Integer order) {
        return new Result<>(Lists.transform(bookDAO.searchBook(flag, key, PageUtils.getCursor(page), PageUtils.offset, order), new Function<Book, BookResponse>() {
            @Override
            public BookResponse apply(Book book) {
                return ConvertUtils.convert(book);
            }
        }));
    }

    @Override
    public Result<List<BookResponse>> getBooks(String key, Integer page, Integer order) {
        return new Result<>(Lists.transform(bookDAO.getBooks(key, PageUtils.getCursor(page), PageUtils.offset, order), new Function<Book, BookResponse>() {
            @Override
            public BookResponse apply(Book book) {
                return ConvertUtils.convert(book);
            }
        }));
    }

    @Override
    public Result<List<BookResponse>> getAllBooks(Integer page, Integer order) {
        return new Result<>(Lists.transform(bookDAO.getAllBooks(PageUtils.getCursor(page), PageUtils.offset, order), new Function<Book, BookResponse>() {
            @Override
            public BookResponse apply(Book book) {
                return ConvertUtils.convert(book);
            }
        }));
    }
}
