package itheima.com.day04;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo05 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
//        注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        // 获取连接
        Connection root = DriverManager.getConnection("jdbc:mysql:///ee_71day00", "root", "123456");
        Statement sta = root.createStatement();

        String sql = "update ";
    }
}
