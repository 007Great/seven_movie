package com.movie.test;

import java.sql.*;

/**
 * @Author: acer
 * @Date: 2020/9/6 23:38
 * @Description:
 */
public class Demo1 {
    //数据库地址“jdbc:mysql://服务器域名:端口号/数据库名称”
    static String url = "jdbc:mysql://localhost:3306/movie?serverTimezone=UTC";
    //用户名
    static String user = "root";
    //用户密码
    static String pwd = "ak315315";

    public static void main(String[] args) {
        //数据库链接对象
        Connection conn = null;
        //数据库命令执行对象
        PreparedStatement pstmt = null;
        //数据库返回结果
        ResultSet rs = null;

        try {
            //1、加载驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, pwd);
            long start = System.currentTimeMillis();
            pstmt = conn.prepareStatement("SELECT\n" +
                    "\ts.sname,\n" +
                    "\tsc.score \n" +
                    "FROM\n" +
                    "\ts,\n" +
                    "\tsc,\n" +
                    "\tc,\n" +
                    "\t( SELECT sno, COUNT( 1) count FROM sc WHERE score < 60 GROUP BY sno ) count \n" +
                    "WHERE\n" +
                    "\ts.sno = sc.sno \n" +
                    "\tAND sc.cno = c.cno \n" +
                    "\tAND count.sno = s.sno \n" +
                    "\tAND count >= 2 \n" +
                    "\tAND score < 60");
            rs = pstmt.executeQuery();
            long finish = System.currentTimeMillis();

            System.out.println("sname\t\t" + "score");
            while (rs.next()) {
                String sname = rs.getString("sname");
                int score = rs.getInt("score");
                System.out.println(sname + "\t\t" + score);
            }
            System.out.println("花费时间" + (finish - start));
            // 完成后关闭
            rs.close();
            pstmt.close();
            conn.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
