package com.dao.impl;

import com.dao.BookDAO;
import com.dao.mapper.BookMapper;
import com.entity.Book;
import org.springframework.stereotype.Component;

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
    public Long addBook(Book book){
        book.setBookId(getSequence());
        if(bookMapper.addBook(book) == 0){
            return new Long(0);
        }
        return book.getBookId();
    }

    @Override
    public Long updateBook(Book book) {
        return bookMapper.updateBook(book) == 0 ? 0l : book.getBookId();
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
    public Integer incrBorrowNum(Long bookId, Integer num) {
        return bookMapper.incrBorrowNum(bookId, num) == 0 ? 0 : num;
    }
}
