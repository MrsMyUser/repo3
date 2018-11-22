package itheima.com.day05.demo01;

import java.util.Date;

public class Student {
    private int id ;
    private String  name;
    private String sex;
    private Date date;
    private double money;

    @Override
    public String toString() {
        return "Student{" +
                "id:" + id +
                ", 姓名：'" + name + '\'' +
                ", 性别：'" + sex + '\'' +
                ", 日期：" + date +
                ", 工资：" + money +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public Student(int id, String name, String sex, Date date, double money) {

        this.id = id;
        this.name = name;
        this.sex = sex;
        this.date = date;
        this.money = money;
    }

    public Student() {

    }
}
