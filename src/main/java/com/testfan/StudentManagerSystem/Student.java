package com.testfan.StudentManagerSystem;

/**
 * @author 孙珑瑜
 * @version 20201026
 */
public class Student {
    String name;
    int age;
    String wx;
    String qq;
    Long phone;

    public Student(){}
    public Student(String name,  Long phone) {
        this.name = name;
        this.phone = phone;
    }

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
    public void showInfo(){
        System.out.println(this.getName()+" "+this.getPhone()+" "+this.getAge()+" "+this.getQq()+" "+this.getWx());
    }


}
