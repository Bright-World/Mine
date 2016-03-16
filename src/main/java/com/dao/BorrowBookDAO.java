package com.dao;

import com.entity.BorrowBook;

import java.util.List;

/**
 * Created by ZhenXi on 2016/1/17.
 */
public interface BorrowBookDAO {

    Long returnBook(Long borrowId, Long bookId, Integer status);

    Long renewBook(Long borrowId, Long bookId);

    List<BorrowBook> getBorrowBook(Long borrowId);

    Integer addBorrowBooks(Long borrowId, List<Long> bookIds);
}
