package itheima.com.day04;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * 查询返回结果几种形式
 * 单行单列 select count(*) from tableName
 * 单行多列==>> 一条数据 select * from tableName where id = ?
 * 单列多行 select 字段 from tableName
 * 多行多列==>> 多条数据  select * from tableName
 *
 */

public class JdbcCurdDql {
    public static void main(String[] args) throws Exception {
        //queryAll();//more 更多 all 所有
        querySingle();//single 单一
    }

    /**
     * 查询单一数据
     */
    private static void querySingle() throws Exception {
        //1.注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        //2.获得连接
        Connection connection = DriverManager.getConnection("jdbc:mysql:///ee71_day04", "root", "root");
        //3.获得语句执行者
        Statement statement = connection.createStatement();
        //4.执行语句
        ResultSet resultSet = statement.executeQuery("select * from tab_user where uid = 5");
        //5.处理结果
        while (resultSet.next()){
            System.out.println(resultSet.getString("name") + "@@" + resultSet.getString("gender"));
        }

        //6.释放资源
        resultSet.close();
        statement.close();
        connection.close();
    }

    /**
     * 查询所有数据 select * from tableName
     */
    private static void queryAll() throws Exception {
        //1.注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        //2.获得连接
        Connection connection = DriverManager.getConnection("jdbc:mysql:///ee71_day04", "root", "root");

        //3.获得语句执行者
        Statement statement = connection.createStatement();

        //4.执行语句
        String sql ="select * from tab_user ";

        //5.处理结果
        //Result结果Set集  我们认为查询的是一个数据集合或者是一个二维表
        ResultSet resultSet = statement.executeQuery(sql);

        //在调用next之前 游标指向表头 Before start of result set
        //String name1 = resultSet.getString("name");
        //System.out.println(name1);
        //遍历数据
        while(resultSet.next()){
            //System.out.println("查询到了数据");
            //每一次移动 会将当前行的数据封装到resultSet对象中 我们就可以获得数据
            //resultSet.getXxx(参数) Xxx类型  参数有两种情况 string int
            //如果参数是数字 表示获得第几列的值 不常用
            int id = resultSet.getInt(1);
            String name = resultSet.getString(2);
            System.out.println("id:"+id + "@@name:" +name);


            //常用参数是sting类型 表示列名
            String gender = resultSet.getString("gender");
            System.out.println("性别:"+ gender);

            //扩展 只要能转换的 就可以使用其他类型获得
            String age = resultSet.getString("age");
            //resultSet.getObject
            System.out.println("年龄:"+ age);
        }
        //在循环遍历之后  After end of result set
        String name2 = resultSet.getString("name");
        System.out.println(name2);

        //6.释放资源
        resultSet.close();
        statement.close();
        connection.close();
    }
}
