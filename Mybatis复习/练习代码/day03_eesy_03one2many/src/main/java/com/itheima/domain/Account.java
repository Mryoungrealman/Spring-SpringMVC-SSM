package com.itheima.domain;

import java.io.Serializable;

/**
 * @Auther: HP
 * @Date: 2020/6/30 16:35
 * @Description: 账户实体类
 */
public class Account implements Serializable {
    private Integer id;
    private Integer uid;
    private Double money;

    //从表实体应该包含一个主表实体的引用
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }


    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", uid=" + uid +
                ", money=" + money +
                ", user=" + user +
                '}';
    }
}
