package itheima.com.demo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/*
* CREATE TABLE employee(
	id INT PRIMARY KEY AUTO_INCREMENT,
	NAME VARCHAR(10),
	sex CHAR(1),
	join_time DATE ,
	money INT
* */
public class Test01 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        avgMoney();
        Class.forName("com.mysql.jdbc.Driver");

        Connection connection = DriverManager.getConnection("jdbc:mysql:///ee_71day00", "root", "123456");

        Statement statement = connection.createStatement();
        List<Employee> list = new ArrayList<>();
        String sql="select *from employee";
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()){
            String id = resultSet.getString("id");
            String name = resultSet.getString("name");
            String sex = resultSet.getString("sex");
            String join_time = resultSet.getString("join_time");
            String money = resultSet.getString("money");
            Employee employee = new Employee();
            employee.setId(id);
            employee.setName(name);
            employee.setSex(sex);
            employee.setDate(join_time);
            employee.setMoney(money);
            list.add(employee);

        }
        for (Employee employee : list) {
            System.out.println(employee);
        }

    }

//        String sql1 = "insert into employee (name,sex,join_time,money)values('张三','男','2013-01-15',8888) ";

    //        int c = statement.executeUpdate(sql3);
//        System.out.println(b);
//        System.out.println(c);
//        System.out.println(a);
//        System.out.println(i);
//
//        int b = statement.executeUpdate(sql4);
//        int a = statement.executeUpdate(sql2);
//        int i = statement.executeUpdate(sql1);
//        String sql4 = "update employee set name = '猪八戒',join_time = '2017-02-01',money = 5300 where id = 3";
//        String sql3 = "insert into employee (name,sex,join_time,money)values('张三','男','2008-08-05',19888) ";
//        String sql2 = "insert into employee (name,sex,join_time,money)values('李四','男','2013-05-25',9888) ";

//    平均工资
    private static void avgMoney() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");

        Connection root = DriverManager.getConnection("jdbc:mysql:///ee_71day00", "root", "123456");
        Statement statement = root.createStatement();
        String sql= "select avg(money)FROM employee";
        ResultSet resultSet = statement.executeQuery(sql);
        String string = resultSet.getString(1);
        System.out.println(string);
    }
}
