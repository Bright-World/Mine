package com.dao;

import com.entity.Borrow;

import java.util.List;

/**
 * Created by ZhenXi on 2016/1/13.
 */
public interface BorrowDAO {

    public Long addBorrow(Borrow borrow);

    public List<Borrow> getBorrows(Integer cursor, Integer offset);

    public Borrow getBorrowById(Long borrowId);

    public List<Borrow> getBorrowByUserId(Long userId, Integer cursor, Integer offset);

    public Long returnBook(Long borrowId, Integer status);

    public Long renew(Long borrowId);

    public Long delBorrow(Long borrowId);
}
