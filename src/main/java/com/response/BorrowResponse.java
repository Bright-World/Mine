package com.response;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

/**
 * Created by ZhenXi on 2016/1/14.
 */
public class BorrowResponse implements Serializable {

    private Long borrowId;

    private Long userId;

    private String nick;

    private Map<Long, String> book;

    private Date returnTime;

    private Integer isRenew;

    private Integer status;

    private Date createDate;

    private Date modifiedDate;

    public Long getBorrowId() {
        return borrowId;
    }

    public void setBorrowId(Long borrowId) {
        this.borrowId = borrowId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public Map<Long, String> getBook() {
        return book;
    }

    public void setBook(Map<Long, String> book) {
        this.book = book;
    }

    public Date getReturnTime() {
        return returnTime;
    }

    public void setReturnTime(Date returnTime) {
        this.returnTime = returnTime;
    }

    public Integer getIsRenew() {
        return isRenew;
    }

    public void setIsRenew(Integer isRenew) {
        this.isRenew = isRenew;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }
}
