package com.movie.dao.impl;

import com.movie.dao.UserDao;
import com.movie.pojo.User;
import com.movie.util.JDBCUtils;

import java.sql.*;

/**
 * @Author: acer
 * @Date: 2020/9/7 09:57
 * @Description:
 */
public class UserDaoImpl implements UserDao {
    public static void main(String[] args) {
        UserDaoImpl userDao = new UserDaoImpl();
        userDao.getUserById(1);
    }
    @Override
    public User getUserById(Integer id) {
        try {
            Connection conn = JDBCUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement("select * from users");
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                System.out.println(rs.getInt("user_id"));
                System.out.println(rs.getString("username"));
                System.out.println(rs.getString("password"));
                System.out.println(rs.getString("user_date"));
            }
            rs.close();
            ps.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int deleteUserById(Integer id) {
        return 0;
    }

    @Override
    public int insertUser(User user) {
        return 0;
    }

    @Override
    public int updateUser(User user) {
        return 0;
    }
}
