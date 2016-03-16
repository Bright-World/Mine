package com.utils;

import com.entity.*;
import com.response.*;

/**
 * Created by ZhenXi on 2016/1/14.
 */
public class ConvertUtils {

    public static final BookResponse convert(Book book) {
        if (book == null) {
            return null;
        }
        BookResponse bookResponse = new BookResponse();
        bookResponse.setCategoryId(book.getCategoryId());
        bookResponse.setBookId(book.getBookId());
        bookResponse.setAuthor(book.getAuthor());
        bookResponse.setCategoryName(book.getName());
        bookResponse.setDesc(book.getDesc());
        bookResponse.setIsbn(book.getIsbn());
        bookResponse.setCreateDate(book.getCreateDate());
        bookResponse.setModifiedDate(book.getModifiedDate());
        bookResponse.setName(book.getName());
        bookResponse.setPic(book.getPic());
        bookResponse.setPrice(book.getPrice());
        bookResponse.setPubDate(book.getPubDate());
        bookResponse.setTimes(book.getTimes());
        bookResponse.setPublisher(book.getPublisher());
        return bookResponse;
    }

    public static final BorrowResponse convert(Borrow borrow) {
        if (borrow == null) {
            return null;
        }
        BorrowResponse borrowResponse = new BorrowResponse();
        borrowResponse.setBorrowId(borrow.getBorrowId());
        borrowResponse.setUserId(borrow.getUserId());
        borrowResponse.setReturnTime(borrow.getReturnTime());
        borrowResponse.setStatus(borrow.getStatus());
        borrowResponse.setIsRenew(borrow.getIsRenew());
        borrowResponse.setCreateDate(borrow.getCreateDate());
        borrowResponse.setModifiedDate(borrow.getModifiedDate());
        return borrowResponse;
    }

    public static final EvaluationResponse convert(Evaluation evaluation) {
        if (evaluation == null) {
            return null;
        }
        EvaluationResponse evaluationResponse = new EvaluationResponse();
        evaluationResponse.setEvaluationId(evaluation.getEvaluationId());
        evaluationResponse.setUserId(evaluation.getUserId());
        evaluationResponse.setBookId(evaluation.getBookId());
        evaluationResponse.setContext(evaluation.getContext());
        evaluationResponse.setCreateDate(evaluation.getCreateDate());
        return evaluationResponse;
    }

    public static final UserResponse convert(User user) {
        if(user == null) {
            return null;
        }
        UserResponse userResponse = new UserResponse();
        userResponse.setUserId(user.getUserId());
        userResponse.setNick(user.getNick());
        userResponse.setCreateDate(user.getCreateDate());
        userResponse.setModifiedDate(user.getModifiedDate());
        return userResponse;
    }

    public static final UserInfoResponse convert(UserInfo userInfo) {
        if (userInfo == null) {
            return null;
        }
        UserInfoResponse userInfoResponse = new UserInfoResponse();
        userInfoResponse.setUserId(userInfo.getUserId());
        userInfoResponse.setName(userInfo.getName());
        userInfoResponse.setDesc(userInfo.getDesc());
        userInfoResponse.setBirthday(userInfo.getBirthday());
        userInfoResponse.setBorrowNum(userInfo.getBorrowNum());
        userInfoResponse.setCreateDate(userInfo.getCreateDate());
        userInfoResponse.setModifiedDate(userInfo.getModifiedDate());
        return userInfoResponse;
    }

    public static final CategoryResponse convert(Category category) {
        if (category == null) {
            return null;
        }
        CategoryResponse categoryResponse = new CategoryResponse();
        categoryResponse.setCategoryId(category.getCategoryId());
        categoryResponse.setName(category.getName());
        categoryResponse.setCreateDate(category.getCreateDate());
        return categoryResponse;
    }
}
