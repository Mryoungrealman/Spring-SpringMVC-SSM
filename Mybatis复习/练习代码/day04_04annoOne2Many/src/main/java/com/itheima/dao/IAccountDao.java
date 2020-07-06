package com.itheima.dao;

import com.itheima.domain.Account;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * @Auther: HP
 * @Date: 2020/7/3 21:51
 * @Description:
 */
public interface IAccountDao {

    /**
     * 返回所有账户,并获取每个账户所属的用户信息
     * @return
     */
    @Select("select * from account")
    @Results(id = "accountMap", value = {
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "uid", column = "uid"),
            @Result(property = "money", column = "money"),
            @Result(property = "user", column = "uid", one = @One(select = "com.itheima.dao.IUserDao.findById", fetchType = FetchType.EAGER))
    })
    List<Account> findAll();

    /**
     * 根据用户id查询账户
     * @param uerId
     * @return
     * id是主键，uid可能重复，所以会返回集合
     */
    @Select("select * from account where uid = #{userId}")
    List<Account> findAccountsByUid(Integer uerId);
}
