package Day0804.Demo01;

/**
 * @author 孙珑瑜
 * @version 0804
 */
public class MainTest {
    String name;
    int age;
    static String school;
    public static void main(String[] args) {
        MainTest.school="马士兵";

        MainTest p1= new MainTest();
        p1.name="张三";
        p1.age = 19;
//        p1.school ="马士兵";

        MainTest p2= new MainTest();
        p2.name="李四";
        p2.age=20;
//        p2.school ="马士兵";
        System.out.println(MainTest.school);

    }
}
