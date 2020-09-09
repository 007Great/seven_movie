package com.movie.dao;

import com.movie.pojo.User;

/**
 * @Author: acer
 * @Date: 2020/9/7 09:49
 * @Description:
 */
public interface UserDao {
    //通过id查询用户
    User getUserById(Integer id);

    //通过id删除用户,返回删除用户的id
    int deleteUserById(Integer id);

    //插入用户，返回插入用户的id
    int insertUser(User user);

    //修改用户，返回修改用户的id
    int updateUser(User user);
}
