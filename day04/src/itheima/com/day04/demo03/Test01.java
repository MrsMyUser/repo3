package itheima.com.day04.demo03;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Test01 {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        transfer();
    }

    private static void transfer() throws SQLException, ClassNotFoundException {
//        注册驱动
//        获取连接
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ee_71day00", "root", "123456");
//        开启事务
        connection.setAutoCommit(false);
        Statement statement = null;
        try {
//            获取语句执行对象
           statement = connection.createStatement();
//           执行语句
            String sql1 = "update acte set monet = monet-100 where cname ='jack'";
            String sql2 = "update acte set monet = monet + 100 where cname ='rose'";
            int i = statement.executeUpdate(sql1);
            System.out.println(i);

            int i1 = statement.executeUpdate(sql2);
            System.out.println(i1);
//            如果从上到下一直执行完毕说明没有错误 就提交事务
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
//            上面有异常
//            回滚事务
            connection.rollback();
        }finally {
            statement.close();
            connection.close();
        }
    }
}
