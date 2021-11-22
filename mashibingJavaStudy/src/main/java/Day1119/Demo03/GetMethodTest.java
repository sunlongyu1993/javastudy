package Day1119.Demo03;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * @author 孙珑瑜
 * @version 211122
 * 反射-获取方法以及调用方法
 */
public class GetMethodTest {
    public static void main(String[] args) throws NoSuchMethodException {
        Class<Student> cls = Student.class;
        System.out.println("获取方法");
        System.out.println("getMethods:获取运行时类的方法还有所有父类中的方法（被public修饰）");
        Method[] methods = cls.getMethods();
        for (Method method : methods) {
            System.out.println(method);
        }
        System.out.println("getDeclaredMethods:获取运行时类中的所有方法");
        Method[] declaredMethods = cls.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println(declaredMethod);
        }
        System.out.println("getMethod：获取指定的方法：");
        Method showInfo = cls.getMethod("ShowInfo");//获取空参方法
        System.out.println(showInfo);
        //获取重载方法中指定参数方法
        Method showInfo1 = cls.getMethod("ShowInfo", int.class, int.class);
        System.out.println(showInfo1);

        System.out.println("获取方法的具体结构：@注解 修饰符 返回值类型  方法名(参数列表) throws XXXXX{}");
        Method myMethod = cls.getMethod("MyMethod",int.class);

        System.out.println("getModifiers：获取方法的修饰符："+Modifier.toString(myMethod.getModifiers()));
        System.out.println("getReturnType：获取方法的返回值类型："+myMethod.getReturnType());
        System.out.println("getName：获取方法的名字："+myMethod.getName());

        System.out.println("getParameterTypes：获取方法的参数列表：=============");
        Class<?>[] parameterTypes = myMethod.getParameterTypes();
        for (Class<?> parameterType : parameterTypes) {
            System.out.println(parameterType);
        }


        System.out.println("调用方法");
    }
}
