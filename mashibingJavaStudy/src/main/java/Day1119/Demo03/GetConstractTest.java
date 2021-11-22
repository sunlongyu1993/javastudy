package Day1119.Demo03;

import java.lang.reflect.Constructor;

/**
 * @author 孙珑瑜
 * @version 211122
 * 反射-获取构造器以及创建对象
 */
public class GetConstractTest {
    public static void main(String[] args) throws Exception {
        Class<Student> cls1 = Student.class;
        //获取public类型的构造器
        Constructor<?>[] cons1 = cls1.getConstructors();
        for (Constructor<?> con : cons1) {
            System.out.println(con);
        }
        System.out.println("===================");//获取所有类型的构造器
        Constructor<?>[] cons2 = cls1.getDeclaredConstructors();
        for (Constructor<?> con : cons2) {
            System.out.println(con);
        }

        System.out.println("===================");
        Constructor<Student> con3 = cls1.getConstructor();
        System.out.println(con3);
        Constructor<Student> con4 = cls1.getDeclaredConstructor(int.class);
        System.out.println(con4);

        Student stu1 = con3.newInstance();
        System.out.println(stu1);

        //私有构造器的
//        Student stu2 = con4.newInstance(2);
//        System.out.println(stu2.getSno());
    }
}
