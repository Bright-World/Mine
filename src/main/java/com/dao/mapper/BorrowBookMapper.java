package com.dao.mapper;

import com.entity.BorrowBook;
import org.apache.ibatis.annotations.*;

/**
 * Created by ZhenXi on 2016/1/17.
 */
public interface BorrowBookMapper {

    final String COLUMN_ALL = "borrow_id,book_id,create_date,modified_date";

    @Update("update borrow_book set status = #{status} where borrow_id = #{borrowId} and book_id = #{bookId}")
    int returnBook(@Param("borrowId")Long borrowId, @Param("bookId")Long bookId, @Param("status")Integer status);

    @Select("select * from borrow_book where borrow_id = #{borrowId} and book_id = #{bookId}")
    @ResultMap("borrowBookMap")
    BorrowBook getBorrowBook(@Param("borrowId")Long borrowId, @Param("bookId")Long bookId);

    @Insert("insert into borrow_book(" + COLUMN_ALL + ") values(#{borrowId}, #{bookId}, now(), now())")
    int addBorrowBooks(@Param("borrowId")Long borrowId, @Param("bookId")Long bookId);

    @Update("update borrow_book set is_renew = 1,modified_date = now() where borrow_id = #{borrowId} and book_id = #{bookId}")
    int renewBook(@Param("borrowId")Long borrowId, @Param("bookId")Long bookId);
}
