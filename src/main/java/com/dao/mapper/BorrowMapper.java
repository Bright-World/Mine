package com.dao.mapper;

import com.entity.Borrow;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by ZhenXi on 2016/1/12.
 */
public interface BorrowMapper {

    final static  String COLUMN_ALL = "borrow_id,user_id,book_id,create_date,modified_date";

    @Insert("insert into borrow(" + COLUMN_ALL + ") values(#{borrowId}, #{userId}, #{bookId}, now(), now())")
    int addBorrow(Borrow borrow);

    @Select("select * from borrow order by modified_date desc limit #{cursor}, #{offset}")
    @ResultMap("borrowMap")
    List<Borrow> getBorrows(@Param("cursor")Integer cursor, @Param("offset")Integer offset);

    @Select("select * from borrow where user_id = #{userId} order by modified_date desc limit #{cursor}, #{offset}")
    @ResultMap("borrowMap")
    List<Borrow> getBorrowByUserId(@Param("userId")Long userId, @Param("cursor")Integer cursor, @Param("offset")Integer offset);

    @Update("update borrow set return_date = now(), status = #{status} where borrow_id = #{borrowId}")
    int returnBook(@Param("borrowId")Long borrowId, @Param("status")Integer status);

    @Update("update borrow set is_renew = 1 where borrow_id = #{borrowId}")
    int renew(Long borrowId);

    @Delete("delete from borrow where borrow_id = #{borrowId}")
    int delBorrow(Long borrowId);
}
