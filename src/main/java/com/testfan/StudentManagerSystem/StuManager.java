package com.testfan.StudentManagerSystem;

import java.util.Scanner;

/**
 * @author 孙珑瑜
 * @version 20201105
 */
public class StuManager {

    public static void main(String[] args) {
        //模拟一个后台系统的操作页面
        //登录，输入用户名以及密码
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入用户名：");
        String name = scanner.next();
        System.out.println("请输入密码：");
        String password = scanner.next();
        // 判断用户名或者密码是否正确，如果正确则进入学员管理系统
        if(Login.login(name,password)){
            System.out.println("==========================欢迎登录学生管理系统=============================");

            int i=1;
            while (i>0){

                // 定义操作规范
                System.out.println("1:新增，2:查询，3:修改，4:删除，5:显示所有，6:退出，请输入你的操作：");
                int op = scanner.nextInt();// 控制台接受输入的数字，进行判断
                switch (op){
                    case 1:
                        System.out.println("请输入学员姓名：");
                        String stuName = scanner.next();
                        System.out.println("请输入学员手机号：");
                        long stuPhone = scanner.nextLong();

                        StuDB.add(stuName,stuPhone);// 新增用户
                        break;
                    case 2://
                        System.out.println("请输入学员手机号：");
                        long stuPhone1 = scanner.nextLong();
                        StuDB.select(stuPhone1);
                        break;
                    case 3:
                        //修改
                        System.out.println("请输入学员手机号：");
                        long stuPhone2 = scanner.nextLong();
                        System.out.println("请输入需要修改学员的属性（name,age,qq,wx,phone）：");
                        String stuAtt = scanner.next();
                        System.out.println("请输入需要修改学员的属性的值：");
                        String stuValue = scanner.next();
                        StuDB.change(stuPhone2,stuAtt,stuValue);
                        break;
                    case 4:
                        //删除
                        System.out.println("请输入学员手机号：");
                        long stuPhone3 = scanner.nextLong();
                        StuDB.delete(stuPhone3);
                        break;
                    case 5:
                        //显示所有
                        StuDB.showAll();
                        break;
                    case 6:
                        i =-1;
                        System.out.println("退出系统");
                        break;
                    default:
                        break;
                }
            }

        }
        //如果用户名或者密码错误，则登录失败
        else {
            System.out.println("请重新输入");
        }
    }
}