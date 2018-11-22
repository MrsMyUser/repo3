package itheima.com.demo;

import java.util.Date;

public class Employee {
    private String id;
    private String name;
    private String sex;
    private Date date;
    private String money;

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                ", date=" + date +
                ", money=" + money +
                '}';
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

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getId() {

        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Employee(String id, String name, String sex, Date date, String money) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.date = date;
        this.money = money;
    }

    public Employee() {

    }

    public void setDate(String join_time) {
    }
}
