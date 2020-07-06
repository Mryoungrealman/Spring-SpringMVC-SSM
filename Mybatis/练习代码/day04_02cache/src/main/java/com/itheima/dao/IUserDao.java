package com.itheima.dao;

import com.itheima.domain.User;

import java.util.List;

/**
 * 用户持久层接口
 */
public interface IUserDao {

    /**
     * 查询所有用户，同时获取到用户下所有账户的信息
     * @return
     */
    List<User> findAll();

    /**
     * 更新用户信息
     * @param user
     */
    void updateUser(User user);

    /**
     * 根据id查询用户信息
     * @param userId
     * @return
     */
    User findById(Integer userId);

    /**
     * 插入用户，用户id属性自增
     * @param user
     */
    void insertUser(User user);
}
