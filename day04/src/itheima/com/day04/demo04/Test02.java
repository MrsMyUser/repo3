package itheima.com.day04.demo04;

import java.sql.*;
import java.util.Scanner;

public class Test02 {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        login();
    }

    private static void login() throws ClassNotFoundException, SQLException {
        Scanner sc  = new Scanner(System.in);
        System.out.println("请输入您的用户名：");
        String username = sc.nextLine();
        System.out.println("请输入你的密码：");
        String password = sc.nextLine();


        Class.forName("com.mysql.jdbc.Driver");
        Connection root = DriverManager.getConnection("jdbc:mysql:///ee_71day00", "root", "123456");
        Statement statement = root.createStatement();

        String sql = "select *FROM  login where username='"+username+" 'and password ='"+ password+"'";
        ResultSet resultSet = statement.executeQuery(sql);

        if (resultSet.next()){
            System.out.println("登陆成功");
        }else {
            System.out.println("登陆失败");
        }
        resultSet.close();
        statement.close();
        root.close();
    }
}
