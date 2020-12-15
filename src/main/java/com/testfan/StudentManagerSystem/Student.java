package com.testfan.StudentManagerSystem;

/**
 * @author 孙珑瑜
 * @version 20201026
 */
public class Student {
    public String name;
    public int age;
    public String wx;
    public String qq;
    public Long phone;

    //public Student(){}
    // 通过构造方法，来初始化 姓名和手机号
    public Student(String name,  Long phone) {
        this.name = name;
        this.phone = phone;
    }
    // 方便获取以及修改属性，可以快捷键生成
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int  getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getWx() {
        //如果微信为null，赋值为空字符串
        if(wx == null){
            wx="";
        }
        return wx;
    }

    public void setWx(String wx) {
        this.wx = wx;
    }

    public String getQq() {
        if(qq == null){
            qq="";
        }
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }
    // 打印学员的所有信息
    public void showInfo(){
        System.out.println(this.getName()+" "+this.getPhone()+" "+this.getAge()+" "+this.getQq()+" "+this.getWx());
    }

    public static void main(String[] args) {
//        Student stu = new Student("sly1",18810677206L);
//        System.out.println(stu.getName());
//        stu.setWx("111222");
//        System.out.println(stu.getWx());
    }
}
