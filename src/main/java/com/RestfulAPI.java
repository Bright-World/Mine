package com;

import com.entity.Book;
import com.entity.Borrow;
import com.entity.Category;
import com.entity.Evaluation;
import com.request.UserRequest;
import com.response.BookResponse;
import com.response.BorrowResponse;
import com.response.CategoryResponse;
import com.response.Result;
import com.service.*;
import com.utils.Const;
import com.utils.ErrorCodeEnum;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;


/**
 * Created by ZhenXi on 2016/1/11.
 */
@RestController
public class RestfulAPI {

    @Resource
    private BookService bookService;

    @Resource
    private UserService userService;

    @Resource
    private EvaluationService evaluationService;

    @Resource
    private BorrowService borrowService;

    @Resource
    private CategoryService categoryService;

    @RequestMapping(value = "/getBooksOrderByBorrowNum", method = RequestMethod.GET)
    public Result<List<BookResponse>> getBooksOrderByBorrowNum(@RequestParam Integer page){
        return bookService.getBooksOrderByBorrowNum(page);
    }

    @RequestMapping(value = "/getBooksOrderByModifiedDate", method = RequestMethod.GET)
    public Result<List<BookResponse>> getBooksOrderByModifiedDate(@RequestParam Integer page) {
        return bookService.getBooksOrderByModifiedDate(page);
    }

    @RequestMapping(value = "/searchBook", method = RequestMethod.GET)
    public Result<List<BookResponse>> searchBook(@RequestParam Integer flag, @RequestParam String key, @RequestParam Integer page) {
        return bookService.searchBook(flag, key, page);
    }

    @RequestMapping(value = "/getBookById", method = RequestMethod.GET)
    public Result<BookResponse> getBookById(@RequestParam Long bookId) {
        return bookService.getBookById(bookId);
    }

    @RequestMapping(value = "/addBook", method = RequestMethod.POST)
    public Result addBook(@RequestBody Book book) {
        return bookService.addBook(book);
    }

    @RequestMapping(value = "/updateBook", method = RequestMethod.POST)
    public Result updateBook(@RequestBody Book book) {
        return bookService.updateBook(book);
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Result login(@RequestBody UserRequest userRequest) {
        return userService.getUser(userRequest);
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public Result register(@RequestBody List<String> snos) {
        return userService.addUser(snos);
    }
    /*public Result register(@RequestBody UserRequest userRequest) {
        return userService.addUser(userRequest);
    }*/

    @RequestMapping(value = "/updateUserInfo", method = RequestMethod.POST)
    public Result updateUserInfo(@RequestBody UserRequest userRequest) {
        return userService.updateUserInfo(userRequest);
    }

    @RequestMapping(value = "/updateUser", method = RequestMethod.POST)
    public Result updateUser(@RequestBody UserRequest userRequest) {
        if(userRequest.getNick() != null) {
            return userService.updateUser(userRequest);
        } else {
            return userService.changePwd(userRequest);
        }
    }

    @RequestMapping(value = "/getUserInfo", method = RequestMethod.GET)
    public Result getUserInfo(@RequestParam Long userId) {
        return userService.getUserInfo(userId);
    }

    @RequestMapping(value = "/addCategory", method = RequestMethod.POST)
    public Result addCategory(@RequestBody Category category) {
        return categoryService.addCategory(category);
    }

    @RequestMapping(value = "/getCategories", method = RequestMethod.GET)
    public Result<List<CategoryResponse>> getCategories() {
        return categoryService.getCategories();
    }

    @RequestMapping(value = "/addEvaluation", method = RequestMethod.POST)
    public Result addEvaluation(@RequestBody Evaluation evaluation) {
        return evaluationService.addEvaluation(evaluation);
    }

    @RequestMapping(value = "/getEvaluationByBookId", method = RequestMethod.GET)
    public Result getEvaluationByBookId(@RequestParam Long bookId, @RequestParam Integer page) {
        return evaluationService.getEvaluationByBookId(bookId, page);
    }

    @RequestMapping(value = "/getEvaluationByUserId", method = RequestMethod.GET)
    public Result getEvaluationByUserId(@RequestParam Long userId, @RequestParam Integer page) {
        return evaluationService.getEvaluationByUserId(userId, page);
    }

    @RequestMapping(value = "/addBorrow", method = RequestMethod.POST)
    public Result addBorrow(@RequestBody Borrow borrow) {
        return borrowService.addBorrow(borrow);
    }

    @RequestMapping(value = "/getBorrows", method = RequestMethod.GET)
    public Result<List<BorrowResponse>> getBorrows(@RequestParam Integer page) {
        return borrowService.getBorrows(page);
    }

    @RequestMapping(value = "/getBorrowByUserId", method = RequestMethod.GET)
    public Result<List<BorrowResponse>> getBorrowByUserId(@RequestParam Long userId, @RequestParam Integer page) {
        return borrowService.getBorrowByUserId(userId, page);
    }

    @RequestMapping(value = "/renew", method = RequestMethod.GET)
    public Result renew(@RequestParam Long borrowId, @RequestParam Long bookId) {
        return borrowService.renew(borrowId, bookId);
    }

    @RequestMapping(value = "/returnBook", method = RequestMethod.GET)
    public Result returnBook(@RequestParam Long borrowId, @RequestParam Long bookId) {
        return borrowService.returnBook(borrowId, bookId);
    }

    @RequestMapping(value = "/delRes/{resType}", method = RequestMethod.DELETE)
    public Result delRes(@PathVariable Integer resType, @RequestBody Long id) {
        switch (resType) {
            case Const.ResType.BOOK : {
                return bookService.delBook(id);
            }
            case Const.ResType.BORROW : {
                return borrowService.delBorrow(id);
            }
            case Const.ResType.CATEGORY : {
                return categoryService.delCategory(id);
            }
            case Const.ResType.EVALUATION : {
                return evaluationService.delEvaluation(id);
            }
            default: {
                return new Result(ErrorCodeEnum.ERROR_RES_TYPE);
            }
        }
    }
}
