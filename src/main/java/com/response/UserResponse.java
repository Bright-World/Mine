package com.response;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by ZhenXi on 2016/1/14.
 */
public class UserResponse implements Serializable {

    private Long userId;

    private String nick;

    private Date createDate;

    private Date modifiedDate;

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
