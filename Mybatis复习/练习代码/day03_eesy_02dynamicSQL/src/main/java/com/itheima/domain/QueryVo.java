package com.itheima.domain;

import java.util.List;

/**
 * @Auther: HP
 * @Date: 2020/6/27 12:48
 * @Description:
 */
public class QueryVo {
    private User user;

    private List<Integer> ids;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }
}
