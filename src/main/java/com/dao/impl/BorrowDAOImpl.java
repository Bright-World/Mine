package com.dao.impl;

import com.dao.BorrowDAO;
import com.dao.mapper.BorrowMapper;
import com.entity.Borrow;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by ZhenXi on 2016/1/13.
 */
@Component("borrowDAO")
public class BorrowDAOImpl extends BaseDAO implements BorrowDAO {

    @Resource
    private BorrowMapper borrowMapper;

    @Override
    String getTableName() {
        return "borrow";
    }

    @Override
    public Long addBorrow(Borrow borrow) {
        borrow.setBorrowId(getSequence());
        return borrowMapper.addBorrow(borrow) == 0 ? 0l : borrow.getBorrowId();
    }

    @Override
    public List<Borrow> getBorrows(Integer cursor, Integer offset) {
        return borrowMapper.getBorrows(cursor, offset);
    }

    @Override
    public Borrow getBorrowById(Long borrowId) {
        return borrowMapper.getBorrowById(borrowId);
    }

    @Override
    public List<Borrow> getBorrowByUserId(Long userId, Integer cursor, Integer offset) {
        return borrowMapper.getBorrowByUserId(userId, cursor, offset);
    }

    /*@Override
    public Long returnBook(Long borrowId, Integer status) {
        return borrowMapper.returnBook(borrowId, status) == 0 ? 0l : borrowId;
    }

    @Override
    public Long renew(Long borrowId) {
        return borrowMapper.renew(borrowId) == 0 ? 0l : borrowId;
    }*/

    @Override
    public Long delBorrow(Long borrowId) {
        return borrowMapper.delBorrow(borrowId) == 0 ? 0l : borrowId;
    }
}
