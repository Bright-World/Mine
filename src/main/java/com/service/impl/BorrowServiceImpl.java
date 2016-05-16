package com.service.impl;

import com.dao.BookDAO;
import com.dao.BorrowBookDAO;
import com.dao.BorrowDAO;
import com.dao.UserDAO;
import com.entity.Borrow;
import com.entity.BorrowBook;
import com.entity.UserInfo;
import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.response.BorrowResponse;
import com.response.Result;
import com.service.BorrowService;
import com.utils.Const;
import com.utils.ConvertUtils;
import com.utils.ErrorCodeEnum;
import com.utils.PageUtils;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.*;

/**
 * Created by ZhenXi on 2016/1/15.
 */
@Component("borrowService")
public class BorrowServiceImpl implements BorrowService {

    @Resource
    private BorrowDAO borrowDAO;

    @Resource
    private BookDAO bookDAO;

    @Resource
    private UserDAO userDAO;

    @Resource
    private BorrowBookDAO borrowBookDAO;

    @Override
    @Transactional
    public Result addBorrow(Borrow borrow) {
        UserInfo userInfo = userDAO.getUserInfo(borrow.getUserId());
        if (userInfo.getBorrowNum() + borrow.getBookIds().size() > Const.MAX_BORROW_NUM) {
            return new Result(ErrorCodeEnum.OUT_OF_NUM);
        }

        Long borrowId = borrowDAO.addBorrow(borrow);
        userInfo.setBorrowNum(userInfo.getBorrowNum() + borrow.getBookIds().size());
        userDAO.updateUserInfo(userInfo);

        if (borrowId == 0) {
            return new Result(ErrorCodeEnum.ADD_ERROR);
        }
        for (Long id : borrow.getBookIds()) {
            bookDAO.incrTimes(id);
            bookDAO.changeStatus(id, Const.BookStatus.ON_BORROW);
        }

        borrowBookDAO.addBorrowBooks(borrowId, borrow.getBookIds());
        return new Result(borrowId);
    }

    @Override
    public Result<List<BorrowResponse>> getBorrows(Integer page) {
        return new Result<>(Lists.transform(borrowDAO.getBorrows(PageUtils.getCursor(page), PageUtils.offset), new Function<Borrow, BorrowResponse>() {
            @Override
            public BorrowResponse apply(Borrow borrow) {
                BorrowResponse borrowResponse = ConvertUtils.convert(borrow);
                borrowResponse.setBook(new HashMap<Long, String>());
                if (borrow.getBookIds() != null) {
                    for (Long id : borrow.getBookIds()) {
                        borrowResponse.getBook().put(id, bookDAO.getBookById(id).getName());
                    }
                }
                borrowResponse.setNick(userDAO.getUserById(borrow.getUserId()).getNick());
                return borrowResponse;
            }
        }));
    }

    @Override
    public Result<List<BorrowResponse>> getBorrowByUserId(final Long userId, Integer page) {
        return new Result<>(Lists.transform(borrowDAO.getBorrowByUserId(userId, PageUtils.getCursor(page), PageUtils.offset), new Function<Borrow, BorrowResponse>() {
            @Override
            public BorrowResponse apply(Borrow borrow) {
                BorrowResponse borrowResponse = ConvertUtils.convert(borrow);
                borrowResponse.setBook(new HashMap<Long, String>());
                if (borrow.getBookIds() != null) {
                    for (Long id : borrow.getBookIds()) {
                        borrowResponse.getBook().put(id, bookDAO.getBookById(id).getName());
                    }
                }
                borrowResponse.setNick(userDAO.getUserById(borrow.getUserId()).getNick());
                return borrowResponse;
            }
        }));
    }

    @Override
    @Transactional
    public Result returnBook(Long borrowId, Long bookId) {
        BorrowBook borrowBook = borrowBookDAO.getBorrowBook(borrowId, bookId);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(borrowBook.getCreateDate());
        calendar.set(Calendar.DAY_OF_YEAR, borrowBook.getIsRenew() == 0 ? Const.BorrowDay.NO_RENEW : Const.BorrowDay.NO_RENEW + Const.BorrowDay.RENEW);
        if (calendar.getTime().before(new Date())) {
            borrowId = borrowBookDAO.returnBook(borrowId, bookId, Const.Return.BEFORE);
        }else {
            borrowId = borrowBookDAO.returnBook(borrowId, bookId, Const.Return.AFTER);
        }
        if (borrowId == 0) {
            return new Result(ErrorCodeEnum.UPDATE_ERROR);
        }

        bookDAO.changeStatus(bookId, Const.BookStatus.CAN_BORROW);
        return new Result(borrowId);
    }

    @Override
    public Result renew(Long borrowId, Long bookId) {
        if (borrowBookDAO.renewBook(borrowId, bookId) == 0) {
            return new Result(ErrorCodeEnum.UPDATE_ERROR);
        }
        return new Result(borrowId);
    }

    @Override
    public Result delBorrow(Long borrowId) {
        if (borrowDAO.delBorrow(borrowId) == 0) {
            return new Result(ErrorCodeEnum.DELETE_ERROR);
        }
        return new Result(borrowId);
    }
}
