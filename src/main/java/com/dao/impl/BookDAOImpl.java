package com.dao.impl;

import com.dao.BookDAO;
import com.dao.mapper.BookMapper;
import com.entity.Book;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by ZhenXi on 2016/1/11.
 */
@Component("bookDAO")
public class BookDAOImpl extends BaseDAO implements BookDAO {

    @Override
    String getTableName() {
        return "book";
    }

    @Resource
    private BookMapper bookMapper;

    @Override
    @Transactional
    public Long addBook(Book book){
        book.setBookId(getSequence());
        if(bookMapper.addBook(book) == 0){
            return new Long(0);
        }
        return book.getBookId();
    }

    @Override
    public Long updateBook(Book book) {
        return bookMapper.updateBook(book) == 0 ? 0 : book.getBookId();
    }

    @Override
    public List<Book> getBooksOrderByBorrowNum(Integer cursor, Integer offset) {
        return bookMapper.getBooksOrderByBorrowNum(cursor, offset);
    }

    @Override
    public List<Book> getBooksOrderByModifiedDate(Integer cursor, Integer offset) {
        return bookMapper.getBooksOrderByModifiedDate(cursor, offset);
    }

    @Override
    public Book getBookById(Long bookId) {
        return bookMapper.getBookById(bookId);
    }

    @Override
    public Long incrTimes(Long bookId) {
        return bookMapper.incrTimes(bookId) == 0 ? 0 : bookId;
    }

    @Override
    public Long delBook(Long bookId) {
        return bookMapper.delBook(bookId) == 0 ? 0 : bookId;
    }

    @Override
    public Long changeStatus(Long bookId, Integer status) {
        return bookMapper.changeStatus(bookId, status) == 0 ? 0 : bookId;
    }
}
