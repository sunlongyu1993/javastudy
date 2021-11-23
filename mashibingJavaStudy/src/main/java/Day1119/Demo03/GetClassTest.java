package Day1119.Demo03;

import java.lang.annotation.Annotation;

/**
 * @author 孙珑瑜
 * @version 211123
 * 反射-获取运行是类的接口，所在包，注解
 */
public class GetClassTest {
    public static void main(String[] args) {
        Class<Student> cls = Student.class;//获取字节码信息：
        System.out.println("获取运行是类的接口=============");
        Class<?>[] classInterface = cls.getInterfaces();
        for (Class<?> aClass : classInterface) {
            System.out.println(aClass);
        }
        System.out.println("得到父类的接口：");
        Class<? super Student> supercls = cls.getSuperclass(); //先得到父类的字节码信息：
        Class<?>[] superinterfaces = supercls.getInterfaces();//得到接口：
        for (Class<?> superinterface : superinterfaces) {
            System.out.println(superinterface);
        }

        System.out.println("获取运行时类所在的包");
        Package aPackage = cls.getPackage();
        System.out.println(aPackage);

        System.out.println("获取运行类的注解===============");
        Annotation[] annotations = cls.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }

    }
}
