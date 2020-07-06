package com.itheima.dao;

import com.itheima.domain.QueryVo;
import com.itheima.domain.User;

import java.util.List;

/**
 * 用户持久层接口
 */
public interface IUserDao {

    /**
     * 查询所有用户
     * @return
     */
    List<User> findAll();

    /**
     * 根据id查询用户信息
     * @param userId
     * @return
     */
    User findById(Integer userId);

    /**
     * 根据名称模糊查询用户信息
     * @param userName
     * @return
     */
    List<User> findByName(String userName);

    /**
     * 根据queryVo中的条件查询用户
     * @param vo
     * @return
     */
    List<User> findUserByVo(QueryVo vo);

    /**
     * 根据传入的参数条件查询
     * @param user 查询的条件，可能为某一属性或全部属性
     * @return
     */
    List<User> findUserByCondition(User user);

    /**
     * 根据QueryVo中的id集合查询用户信息
     * @param vo
     * @return
     */
    List<User> findUserInIds(QueryVo vo);

    void insertUser(User user);
}
