package itheima.com.day04;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo {
    public static void main(String[] args) throws Exception {
//        注册驱动
        Class.forName("com.mysql.jdbc.Driver");
//        获得连接
        String ur1 = "jdbc:mysql://localhost:3306/ee_71day00";
        String user = "root";
        String password = "123456";
        Connection root = DriverManager.getConnection(ur1,user,password);
//        System.out.println(root);
//        从连接中拿到一个statement对象
        Statement sta = root.createStatement();
//        插入记录
        String sql = "insert into cate(cname)VALUES ('手机');";
        int i = sta.executeUpdate(sql);
        System.out.println("影响的行数："+i);
//        修改记录
        sql = "UPDATE cate set cname = '汽车' where cid = 4";
        int i1 = sta.executeUpdate(sql);
        System.out.println("影响的行数："+i1);
//        删除记录
        sql = "delete from cate where cid =6";
        int i2 = sta.executeUpdate(sql);
        System.out.println("影响的行数："+i2);
        sta.close();
        root.close();
    }

}
