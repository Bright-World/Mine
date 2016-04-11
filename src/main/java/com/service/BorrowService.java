package com.service;

import com.entity.Borrow;
import com.response.BorrowResponse;
import com.response.Result;

import java.util.List;

/**
 * Created by ZhenXi on 2016/1/15.
 */
public interface BorrowService {

    public Result addBorrow(Borrow borrow);

    public Result<List<BorrowResponse>> getBorrows(Integer page);

    public Result<List<BorrowResponse>> getBorrowByUserId(Long userId, Integer page);

    public Result returnBook(Long borrowId, Long bookId);

    public Result renew(Long borrowId, Long bookId);

    public Result delBorrow(Long borrowId);
}
