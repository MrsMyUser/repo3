package itheima.com.day04;

import java.sql.*;

/**
 * 工具类 : 使用快捷方便
 */
public class JdbcUtils {
    /**
     * 快捷键抽取
     * @return
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        //1.注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        //2.获得连接
        return DriverManager.getConnection("jdbc:mysql:///ee71_day04", "root", "root");
    }

    /**
     * 释放资源方法
     */
    public static void close(ResultSet resultSet , Statement statement , Connection connection){
        //快速编写代码  ctrl + alt + t      快速抽取方法 ctrl + alt + m
        try {
            if(resultSet!=null){//报错
                resultSet.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            if(statement!=null){
                statement.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            if(connection!=null){
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
