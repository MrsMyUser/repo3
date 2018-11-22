package itheima.com.day04;

import java.sql.*;

public class Dome01 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
//        注册驱动
        Class.forName("com.mysql.jdbc.Driver");
//        获得连接
        Connection root = DriverManager.getConnection("jdbc:mysql:///ee_71day00", "root", "123456");
//        获得语句执行
        Statement sta = root.createStatement();
//        查询用query
        String sql ="select *FROM cate ";
        ResultSet rs = sta.executeQuery(sql);

//        内部有个指针，只能取指针那条记录
        while (rs.next()){//指针移动一行，有数据才返回true
//            取出数据
            int cid = rs.getInt("cid");
            String cname = rs.getString("cname");
            System.out.println(cid+"=="+cname);
        }
        rs.close();
        sta.close();
        root.close();

    }
}
