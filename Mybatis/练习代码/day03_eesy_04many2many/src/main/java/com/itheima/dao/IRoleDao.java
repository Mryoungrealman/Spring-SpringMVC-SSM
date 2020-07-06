package com.itheima.dao;

import com.itheima.domain.Role;

import java.util.List;

/**
 * @Auther: HP
 * @Date: 2020/6/30 22:19
 * @Description:
 */
public interface IRoleDao {
    /**
     * 查询所有角色
     * @return
     */
    List<Role> findAll();


}
