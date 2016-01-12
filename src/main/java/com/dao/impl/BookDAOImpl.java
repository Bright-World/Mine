package com.dao.impl;

import com.dao.BookDAO;
import org.springframework.stereotype.Component;

/**
 * Created by ZhenXi on 2016/1/11.
 */
@Component("bookDAO")
public class BookDAOImpl extends BaseDAO implements BookDAO {

    @Override
    protected String getTableName() {
        return "book";
    }
}
