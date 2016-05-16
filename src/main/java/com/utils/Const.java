package com.utils;

/**
 * Created by ZhenXi on 2016/1/13.
 */
public interface Const {

    final int MAX_BORROW_NUM = 10;

    interface Return {
        final int BEFORE = 1;
        final int AFTER = 2;
    }

    interface BorrowDay {
        final int NO_RENEW = 30;
        final int RENEW = 15;
    }

    interface ResType{
        final int BOOK = 1;
        final int BORROW = 2;
        final int EVALUATION = 3;
        final int CATEGORY = 4;
    }

    interface BookStatus {
        final int CAN_BORROW = 0;
        final int ON_BORROW = 1;
    }
}
