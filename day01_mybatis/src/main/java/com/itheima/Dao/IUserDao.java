package com.itheima.Dao;

import com.itheima.domain.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 用户的持久层接口
 */
public interface IUserDao  {
    @Select("select * from user")
    public List<User> findAll();
}
