package com.example.jdbc;

import com.mysql.jdbc.PreparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Test {
    public static void main(String[] args) throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");//加载驱动
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String jdbc = "jdbc:mysql://127.0.0.1:3306/test?characterEncoding=GBK";
        Connection conn = null;//链接到数据库

        conn = DriverManager.getConnection(jdbc, "root", "123456");
        conn.setAutoCommit(false);
        Statement state = conn.createStatement();   //容器
        String sql = "insert into sys_users values('1108','张伟','汉企')";   //SQL语句
        state.executeUpdate(sql);         //将sql语句上传至数据库执行
        conn.commit();
        // 批处理
        PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement("insert into sys_users values(?,?,?)");
        for(int i =1;i<1000;i++){
            pstmt.setInt(1,i);
            pstmt.setString(2,"张三"+i);
            pstmt.setString(3,"奥利给！");
            pstmt.addBatch();



        }
        pstmt.executeBatch();
        pstmt.close();
        conn.commit();

        conn.close();//关闭通道
    }
}
