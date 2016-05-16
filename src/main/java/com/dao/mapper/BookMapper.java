package com.dao.mapper;

import com.entity.Book;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by ZhenXi on 2016/1/11.
 */
public interface BookMapper {

    final static String COLUMN_ALL = "book_id,`name`,category_id,author,publisher,isbn,pub_date,`desc`,price,pic,create_date,modified_date";

    @Insert("insert into book(" + COLUMN_ALL + ") values(#{bookId}, #{name}, #{categoryId}, #{author, typeHandler=com.dao.typeHandler.JsonListHandler}, #{publisher}, #{isbn}, #{pubDate}, #{desc}, #{price}, #{pic, typeHandler=com.dao.typeHandler.JsonListHandler}, now(), now())")
    int addBook(Book book);

    @Select("select * from book where status = 0 order by times, modified_date desc limit #{cursor}, #{offset}")
    @ResultMap("bookMap")
    List<Book> getBooksOrderByBorrowNum(@Param("cursor")Integer cursor, @Param("offset")Integer offset);

    @Select("select * from book where status = 0 order by modified_date desc limit #{cursor}, #{offset}")
    @ResultMap("bookMap")
    List<Book> getBooksOrderByModifiedDate(@Param("cursor")Integer cursor, @Param("offset")Integer offset);

    @Select("select * from book where book_id = #{bookId}")
    @ResultMap("bookMap")
    Book getBookById(Long bookId);

    @Update("update book set times = times + 1 where book_id = #{bookId}")
    int incrTimes(@Param("bookId")Long bookId);

    int updateBook(Book book);

    @Delete("delete from book where book_id = #{bookId}")
    int delBook(Long bookId);

    @Update("update book set status = #{status} where book_id = #{bookId}")
    int changeStatus(@Param("bookId")Long bookId, @Param("status")Integer status);

    List<Book> searchBook(@Param("flag") Integer flag, @Param("key") String key, @Param("cursor") Integer cursor, @Param("offset") Integer offset);
}
