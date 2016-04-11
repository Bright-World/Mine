package com.dao.impl;

import com.dao.BorrowBookDAO;
import com.dao.mapper.BorrowBookMapper;
import com.entity.BorrowBook;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by ZhenXi on 2016/1/17.
 */
@Component("borrowBookDAO")
public class BorrowBookDAOImpl implements BorrowBookDAO {

    @Resource
    private BorrowBookMapper borrowBookMapper;

    @Override
    public Long returnBook(Long borrowId, Long bookId, Integer status) {
        return borrowBookMapper.returnBook(borrowId, bookId, status) == 0 ? 0 : bookId;
    }

    @Override
    public BorrowBook getBorrowBook(Long borrowId, Long bookId) {
        return borrowBookMapper.getBorrowBook(borrowId, bookId);
    }

    @Override
    public Integer addBorrowBooks(Long borrowId, List<Long> bookIds) {
        int num = 0;
        for (Long bookId : bookIds) {
            borrowBookMapper.addBorrowBooks(borrowId, bookId);
            num ++;
        }
        return num;
    }

    @Override
    public Long renewBook(Long borrowId, Long bookId) {
        return borrowBookMapper.renewBook(borrowId, bookId) == 0 ? 0 : borrowId;
    }
}
