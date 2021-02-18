package com.testfan.Mybatiss.domain;

import javax.xml.crypto.Data;
import java.io.Serializable;
import java.util.Date;

/**
 * @author 孙珑瑜
 * @version User
 */
// 实体类
public class User implements Serializable {
    private Integer id;
    private String username;
    private String password;
    private Integer age;
    private Integer gender;
    private String phonenum;
    private String email;
    private String address;
    private Date createtime;
    private Data updatatime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getPhonenum() {
        return phonenum;
    }

    public void setPhonenum(String phonenum) {
        this.phonenum = phonenum;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Data getUpdatatime() {
        return updatatime;
    }

    public void setUpdatatime(Data updatatime) {
        this.updatatime = updatatime;
    }

    @Override
    public String toString() {
        return "domin{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                ", phonenum='" + phonenum + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", createtime=" + createtime +
                ", updatatime=" + updatatime +
                '}';
    }
}
