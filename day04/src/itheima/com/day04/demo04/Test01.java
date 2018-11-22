package itheima.com.day04.demo04;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Test01 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

//        insert();
//        update();


        delete();


        /*1 .注册驱动
        * 2.获得连接
        * 3.获得语句执行者
        * 4.执行语句
        * 5.处理结果
        * 6.释放资源
        * */

    }

    private static void delete() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");

        Connection root = DriverManager.getConnection("jdbc:mysql:///ee_71day00", "root", "123456");

        Statement statement = root.createStatement();
        String sql = "delete from cate where cid = 3";
        int i = statement.executeUpdate(sql);
        System.out.println(i);
        statement.close();
        root.close();
    }

    private static void update() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");

        Connection c = DriverManager.getConnection("jdbc:mysql:///ee_71day00", "root", "123456");

        Statement statement = c.createStatement();

        String sql = "update cate set cname= 'jaaa',monet =1100 where cname='jack'";
        int i = statement.executeUpdate(sql);

        System.out.println(i);

        statement.close();
        c.close();

    }

    private static void insert() throws ClassNotFoundException, SQLException {
        /*1 .注册驱动
         * 2.获得连接
         * 3.获得语句执行者
         * 4.执行语句
         * 5.处理结果
         * 6.释放资源
         * */
        Class.forName("com.mysql.jdbc.Driver");

        Connection connection = DriverManager.getConnection("jdbc:mysql:///ee_71day00", "root", "123456");

        Statement statement = connection.createStatement();

        String sql =  "insert into cate (cname,monet) values ('tom',1000 )";
        int i = statement.executeUpdate(sql);
        System.out.println(i);
        statement.close();
        connection.close();

    }
}
