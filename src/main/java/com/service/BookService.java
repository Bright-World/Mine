package com.service;

import com.entity.Book;
import com.response.BookResponse;
import com.response.Result;

import java.util.List;

/**
 * Created by ZhenXi on 2016/1/13.
 */
public interface BookService {

    Result addBook(Book book);

    Result updateBook(Book book);

    Result<List<BookResponse>> getBooksOrderByBorrowNum(Integer page);

    Result<List<BookResponse>> getBooksOrderByModifiedDate(Integer page);

    Result<BookResponse> getBookById(Long bookId);

    Result delBook(Long bookId);

    Result<List<BookResponse>> searchBook(Integer flag, String key, Integer page, Integer order);

    Result<List<BookResponse>> getBooks(String key, Integer page, Integer order);

    Result<List<BookResponse>> getAllBooks(Integer page, Integer order);
}
