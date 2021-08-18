package Day0817.Demo02;

/**
 * @author 孙珑瑜
 * @version 210817
 */
public class MainTest2 {
    public static void main(String[] args) {
        Cat cat = new Cat();
        Animal a = cat;//向上转型
        a.shout();

        Cat an =(Cat)a;//向下转型
        an.scratch();
        int age = an.age;
        System.out.println(age);
    }
}
