package com.itheima.dao;

import com.itheima.domain.Account;
import com.itheima.domain.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * @Auther: HP
 * @Date: 2020/7/2 14:33
 * @Description: 在Mybatis中针对CRUD共有四个注解：
 * @Select @Insert @Update @Delete
 */
public interface IUserDao {

    /**
     * 查询所有用户
     * @return
     */
    @Select("select * from user")
    @Results(id = "userMap", value = {
            @Result(id = true, property = "userId", column = "id"),
            @Result(property = "userName", column = "username"),
            @Result(property = "userSex", column = "sex"),
            @Result(property = "userAddress", column = "address"),
            @Result(property = "userBirthday", column = "birthday"),
//            下面的column中的参数是select语句中的入口参数
            @Result(property = "accounts", column = "id",
                    many = @Many(select = "com.itheima.dao.IAccountDao.findAccountsByUid",
                            fetchType = FetchType.LAZY))
    })
    List<User> findAll();

    /**
     * 根据id查询用户
     * @param id
     * @return
     */
    @Select("select * from user where id=#{id}")
//    @ResultMap(value = {"userMap"})
    @ResultMap("userMap")
    User findById(Integer id);

    /**
     * 根据用户名称模糊查询
     * @param username
     * @return
     */
    @Select("select * from user where username like #{username}")
    @ResultMap("userMap")
    List<User> findUserByName(String username);

}
