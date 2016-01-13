package com;

import com.service.BookService;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


/**
 * Created by ZhenXi on 2016/1/11.
 */
@RestController
public class RestfulAPI {

    @Resource
    private BookService bookService;
}
