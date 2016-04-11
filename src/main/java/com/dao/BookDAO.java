package com.dao;

import com.entity.Book;

import java.util.List;

/**
 * Created by ZhenXi on 2016/1/11.
 */
public interface BookDAO {

    public Long addBook(Book book);

    public Long updateBook(Book book);

    public List<Book> getBooksOrderByBorrowNum(Integer cursor, Integer offset);

    public List<Book> getBooksOrderByModifiedDate(Integer cursor, Integer offset);

    public Book getBookById(Long bookId);

    public Long incrTimes(Long bookId);

    public Long delBook(Long bookId);

    public Long changeStatus(Long bookId, Integer status);
}
