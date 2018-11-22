package itheima.com.day05.demo01;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test01 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

//        添加员工信息
//        addEmployee();
//        更改员工信息
//        setEmpolyee();
//        封装成集合
//        listEmployee();
//        查询平均值工资
//        avgMoney();
//        获取张姓员工
//        getZhang();
//        id查询
//        getId();
//        id删除
        System.out.println("删除："+deleteId()+"行");
    }

    private static int deleteId() throws ClassNotFoundException, SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要删除的id：");
        int id = sc.nextInt();
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql:///ee_71day00", "root", "123456");

        Statement statement = connection.createStatement();
        String sql = "delete FROM  employee where id ="+id+"";

        int a = statement.executeUpdate(sql);

        statement.close();
        connection.close();
        return a;
    }

    //        查询平均值工资
    private static void avgMoney() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection c = DriverManager.getConnection("jdbc:mysql:///ee_71day00", "root", "123456");

        Statement statement = c.createStatement();

        String sql ="select avg(money) FROM employee";

        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()){
            int anInt = resultSet.getInt(1);
            System.out.println("平均工资为："+anInt);
        }
        resultSet.close();
        statement.close();
        c.close();
    }

    //      3.封装集合返回
    private static void listEmployee() throws ClassNotFoundException, SQLException {
        List<Student> list = new ArrayList<>();
        Class.forName("com.mysql.jdbc.Driver");

        Connection connection = DriverManager.getConnection("jdbc:mysql:///ee_71day00","root","123456");

        Statement statement = connection.createStatement();

        String sql = "select *from employee";

        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String sex = resultSet.getString("sex");
            Date join_time = resultSet.getDate("join_time");
            int money = resultSet.getInt("money");
            Student student = new Student();
            student.setId(id);
            student.setName(name);
            student.setSex(sex);
            student.setDate(join_time);
            student.setMoney(money);

            list.add(student);


        }

        for (Student student : list) {

            System.out.println(student);
        }
        resultSet.close();
        statement.close();
        connection.close();
    }

    //    更改员工信息
    private static void setEmpolyee() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");

        Connection c = DriverManager.getConnection("jdbc:mysql:///ee_71day00", "root", "123456");

        Statement statement = c.createStatement();

        String sql = "update employee set name= '猪八戒' ,join_time='2017-02-01',money=5300 WHERE id=3 ";

        int i = statement.executeUpdate(sql);

        System.out.println(1);

        statement.close();
        c.close();

    }
//    添加员工信息
    private static void addEmployee() throws ClassNotFoundException, SQLException{
        //       注册驱动
        Class.forName("com.mysql.jdbc.Driver");
//        建立连接
        Connection connection = DriverManager.getConnection("jdbc:mysql:///ee_71day00", "root", "123456");
//        获得语句执行者
        Statement statement = connection.createStatement();
//        执行语句

        String sql1 = "insert into employee (name,sex,join_time,money)values ('张三','男','2012-01-03',8888)";
        String sql2 = "insert into employee (name,sex,join_time,money)values ('李四','男','2014-05-03',7888)";
        String sql3 = "insert into employee (name,sex,join_time,money)values ('王五','男','2012-01-03',18888)";

        int i = statement.executeUpdate(sql1);
        int a = statement.executeUpdate(sql2);
        int b = statement.executeUpdate(sql3);

        System.out.println(i);
        System.out.println(a);
        System.out.println(b);

        statement.close();
        connection.close();

    }
    //        获取张姓员工
    public static void getZhang() throws ClassNotFoundException, SQLException {

        ArrayList<Student>list = new ArrayList<>();
        Class.forName("com.mysql.jdbc.Driver");

        Connection connection = DriverManager.getConnection("jdbc:mysql:///ee_71day00", "root", "123456");

        Statement statement = connection.createStatement();

        String sql = "select *from employee where name LIKE '张%'";

        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()){

            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String sex = resultSet.getString("sex");
            Date join_time = resultSet.getDate("join_time");
            int money = resultSet.getInt("money");

            Student  student = new Student();

            student.setId(id);
            student.setName(name);
            student.setSex(sex);
            student.setDate(join_time);
            student.setMoney(money);

            list.add(student);


        }
        for (Student student : list) {
            System.out.println(student);
        }
        resultSet.close();
        statement.close();
        connection.close();

    }
    //        id查询
    public static void getId() throws ClassNotFoundException, SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要查询的id：");
        int id = sc.nextInt();

        List<Student>list= new ArrayList<>();
        Class.forName("com.mysql.jdbc.Driver");

        Connection connection = DriverManager.getConnection("jdbc:mysql:///ee_71day00", "root", "123456");

        Statement statement = connection.createStatement();

        String sql = "select *FROM  employee where id = "+id+"";
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()){
            int idd = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String sex = resultSet.getString("sex");
            Date join_time = resultSet.getDate("join_time");
            int money = resultSet.getInt("money");

            Student  student = new Student();

            student.setId(id);
            student.setName(name);
            student.setSex(sex);
            student.setDate(join_time);
            student.setMoney(money);

            list.add(student);
        }

        for (Student student : list) {
            System.out.println(student);
        }

        resultSet.close();
        statement.close();
        connection.close();
    }

}
