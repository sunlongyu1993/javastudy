package Day1119.Demo03;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * @author 孙珑瑜
 * @version 211122
 * 反射-获取属性以及对属性进行赋值
 */
public class GetFieldTest {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, InstantiationException {
        //获取运行时类的字节码信息：
        Class<Student> cls = Student.class;
        //获取属性
        System.out.println("获取运行时类和父类中被public修饰的属性：=====================");
        //获取运行时类和父类中被public修饰的属性
        Field[] fields = cls.getFields();
        for (Field field : fields) {
            System.out.println(field);
        }
        System.out.println("获取运行时类中的所有属性：=====================");
        Field[] declaredFields = cls.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField);
        }
        System.out.println("获取指定的属性：=====================");
        Field clsscore = cls.getField("score");
        System.out.println(clsscore);

        Field dfieldsno = cls.getDeclaredField("sno");
        System.out.println(dfieldsno);

        System.out.println("属性的具体结构-demo:private int sno =====================");
        System.out.println("属性的具体结构-获取属性的修饰符 =====================");
//        int modifiers = dfieldsno.getModifiers();
        System.out.println(Modifier.toString(dfieldsno.getModifiers()));
        System.out.println("属性的具体结构-获取属性的数据类型 =====================");
        Class<?> dfieldsnoType = dfieldsno.getType();
        System.out.println(dfieldsnoType.getName());
        System.out.println("属性的具体结构-获取属性的名字 =====================");
        System.out.println(dfieldsno.getName());

        System.out.println("给属性赋值，必须要有对象 =====================");
        Field scoreField = cls.getField("score");//获取指定属性
        Student stu = cls.newInstance();//创建实例
        scoreField.set(stu,99.99);
        System.out.println(stu);
    }

}

