package Day0817.Demo04;

/**
 * @author 孙珑瑜
 * @version 210817
 */
public class FinalTest {
    public static void main(String[] args) {
       final Dog dog = new Dog();
        a(dog);
        b(dog);
    }


    public static void a(Dog d1){
        d1 = new  Dog();
    }

    public static void b(final Dog d2){
//        d2 = new  Dog();
    }
}
