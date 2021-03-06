package com.dao.mapper;

import com.entity.Book;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by ZhenXi on 2016/1/11.
 */
public interface BookMapper {

    final static String COLUMN_ALL = "book_id,`name`,category_id,author,publisher,isbn,pub_date,`desc`,price,pic,create_date,modified_date";

    @Insert("insert into book(" + COLUMN_ALL + ") values(#{bookId}, #{name}, #{categoryId}, #{author}, #{publisher}, #{isbn}, #{pubDate}, #{desc}, #{price}, #{pic}, now(), now())")
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

    List<Book> searchBook(@Param("flag") Integer flag, @Param("key") String key, @Param("cursor") Integer cursor, @Param("offset") Integer offset, @Param("order") String order);

    @Select("select * from book where name like #{key} or isbn like #{key} or author like #{key} or publisher like #{key} or category_id in (select category_id from category where name like #{key}) order by #{order} desc limit #{cursor},#{offset}")
    @ResultMap("bookMap")
    List<Book> getBooks(@Param("key")String key, @Param("cursor") Integer cursor, @Param("offset") Integer offset, @Param("order") String order);

    @Select("select * from book order by #{order} desc limit #{cursor}, #{offset}")
    @ResultMap("bookMap")
    List<Book> getAllBooks(@Param("cursor")Integer cursor, @Param("offset") Integer offset, @Param("order") String order);
}
