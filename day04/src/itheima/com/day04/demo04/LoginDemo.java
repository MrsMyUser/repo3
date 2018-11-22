package itheima.com.day04.demo04;

import itheima.com.day04.JdbcUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 * 案例需求: 模拟用户输入账号和密码登录网站
 * 1.让用户输入用户名和密码
 * 2.拿到用户名和密码进行具体的查询
 * SELECT * FROM login where username = 用户名 and password = 密码
 */
public class LoginDemo {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        login();
    }

    /**
     * 登陆案例
     */
    private static void login() throws SQLException, ClassNotFoundException {
        //1.需要让用户输入
        Scanner scanner  = new Scanner(System.in);
        System.out.println("请输入您的用户名:");
        String username = scanner.nextLine();

        System.out.println("请输入您的密码:");
        String password = scanner.nextLine();
        //System.out.println(username +"@@" + password);

        //2.获得用户输入的用户名和密码 进行查询
        //2.1 获得连接
        Connection connection = JdbcUtils.getConnection();
        //2.2 获得语句执行者
        Statement statement = connection.createStatement();
        //2.3 执行语句
        String sql = "select * from login where username = '"+username+"' and password = '"+password+"' ";
        //System.out.println(sql);
        ResultSet resultSet = statement.executeQuery(sql);

        //2.4 处理结果集
        //返回是一个boolean
        if(resultSet.next()){//true 有数据
            System.out.println("登录成功");
        }else{//没数据
            System.out.println("登录失败");
        }
        //2.5 释放资源
        JdbcUtils.close(resultSet , statement , connection);
    }
}
