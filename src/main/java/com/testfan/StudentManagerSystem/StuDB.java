package com.testfan.StudentManagerSystem;

import java.util.Collection;
import java.util.HashMap;

/**
 * @author 孙珑瑜
 * @version 20201026
 */
public class StuDB {
    // 使用map 对象来存储数据
    public static HashMap<Long,Student> stuMap = new HashMap<Long,Student>();
    //封装添加学员方法
    public static void add(String name,long phone){
        // 判断添加的手机号是否存在
        if(!stuMap.containsKey(phone)){
            Student stu1 = new Student(name,phone);
            stuMap.put(phone,stu1);
        }
        else {
            System.out.println(phone+"已存在,请判断输入的手机号是否正确");
        }
    }
    //封装修改的方法
    public static void change(long phone,String key,String value){
        if(stuMap.containsKey(phone)){
            Student student = stuMap.get(phone);
            if(key.equalsIgnoreCase("name")){
                student.setName(value);
            }
            else if(key.equalsIgnoreCase("qq")){
                student.setQq(value);
            }
            else if(key.equalsIgnoreCase("wx")){
                student.setWx(value);
            }
            else if(key.equalsIgnoreCase("age")){
                student.setAge(Integer.parseInt(value));
            }
            else if(key.equalsIgnoreCase("phone")){
                // 首先判断想要修改的手机号是否存在，如果存在，执行下列不在
                if(stuMap.containsKey(Long.parseLong(value))){
                    System.out.println(Long.parseLong(value)+"已经存在，不能修改");
                }
                //如果想要修改的手机号不存在，就执行下列步骤
                else{
                    student.setPhone(Long.parseLong(value));
                    stuMap.remove(phone);// 删除原来手机号对应的学员信息
                    //新增新的手机号对应的学员信息
                    stuMap.put(Long.parseLong(value),student);
                }
            }
        }
        else {
            System.out.println(phone+"不存在，请输入正确手机号");
        }

    }
    //封装删除方法
    public static void delete(long phone){
        if(stuMap.containsKey(phone)){
            stuMap.remove(phone);
        }
        else {
            System.out.println(phone+"不存在,请判断输入的手机号是否正确");
        }
    }
    //封装查询方法
    public static  void select(long phone){
        if(stuMap.containsKey(phone)){
            Student student = stuMap.get(phone);
            student.showInfo();
        }
        else {
            System.out.println(phone+"不存在,请判断输入的手机号是否正确");
        }
    }
    //显示当前所有的学员信息
    public static void showAll(){
        Collection<Student> students = stuMap.values();
        for (Student student:students) {
            student.showInfo();
        }

    }

    public static void main(String[] args) {
//        Student stu1 = new Student("sly1",18810677206L);
//        stuMap.put(18810677206L,stu1);
        // 类方法不用实例化，可以直接调用，在当前类中，可以直接调用静态类；
        add("sly",18810677206L);
//        Student student1 = stuMap.get(18810677206L);
//        System.out.println(student1.getName());
        add("sly1",18810677207L);
//        Student student2 = stuMap.get(18810677207L);
//        System.out.println(student2.getName());
//        //删除不存在的手机号
//        delete(18810677208L);
////        删除成功
//        delete(18810677206L);
//        // 删除成功则打印false
//        System.out.println(stuMap.containsKey(18810677206L));
//        System.out.println("======================");
        change(18810677206L,"phone","18810677208");
//        Student student3 = stuMap.get(18810677208L);
//        System.out.println(student3.getName());
        change(18810677208L,"wx","wx");
        change(18810677208L,"qq","qq");
        change(18810677208L,"age","18");
        Student student1 = stuMap.get(18810677208L);
        student1.showInfo();




    }



}
