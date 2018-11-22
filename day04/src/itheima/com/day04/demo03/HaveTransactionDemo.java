package itheima.com.day04.demo03;


import itheima.com.day04.JdbcUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class HaveTransactionDemo {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        //transactionTemplate();//事务模版Template
        //转账
        transfer();

    }

    /**
     * 有事务的转账
     */
    private static void transfer() throws SQLException, ClassNotFoundException {
        //1.try
        //2.获得连接
        Connection connection = JdbcUtils.getConnection();
        //3.通过连接开启事务
        connection.setAutoCommit(false);
        Statement statement = null;
        try{
            //2.1 获得语句执行者对象
            statement = connection.createStatement();
            //2.2 执行语句
            String sql1 = "update account set money = money - 100 where username='jack'";
            String sql2 = "update account set money = money + 100 where username='rose'";
            int count1 = statement.executeUpdate(sql1);
            System.out.println(count1);

            //模拟异常
            int i = 1/0;

            int count2 = statement.executeUpdate(sql2);
            System.out.println(count2);
            //2.3 处理结果
            //2.4 释放资源 --不能在这释放

            //4.提交事务
            connection.commit();
        }catch(Exception e){
            e.printStackTrace();
            //4.回滚事务
            connection.rollback();
        }finally {
            JdbcUtils.close(null , statement,connection);
        }

    }








    /**
     * 模版代码
     */
    private static void transactionTemplate() throws SQLException, ClassNotFoundException {
        //1.必须try 如果有异常 相当于失败 需要捕获到并回滚数据
        //一个connection相当于一个黑窗口 cmd
        //获得连接
        Connection connection = JdbcUtils.getConnection();

        //开启事务 关闭自动提交事务
        connection.setAutoCommit(false);
        try {

            //能执行到最后一行代码 表示程序没有任何异常 需要提交事务
            connection.commit();
        }catch (Exception e){
            e.printStackTrace();
            //如果报错在catch 需要回滚数据
            connection.rollback();
        }
    }

}
