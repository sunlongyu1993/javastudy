package Day1119.Demo02;

/**
 * @author 孙珑瑜
 * @version 211119
 * 获取字节码信息的4种方式
 */
public class TestGetInfor {
    public static void main(String[] args) throws Exception {
        //方法1：通过getClass();-不常用
        Person p = new Person();
        Class<? extends Person> c1 = p.getClass();
        System.out.println(c1);
        //方法2：通过内置class属性——不常用
        Class<Person> c2 = Person.class;
        System.out.println(c2);

        //方法3：常用，class类的静态方法forName
        Class<?> c3 = Class.forName("Day1119.Demo02.Person");
        System.out.println(c3);

    }
}
