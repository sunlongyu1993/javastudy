package Day0817.Demo01;

/**
 * @author 孙珑瑜
 * @version 210817
 */
public class MainTest {
    public static void main(String[] args) {
        Girl girl= new Girl();
        Dog dog = new Dog();
        Cat cat = new Cat();
//        Animal animal = new Animal();
//        Animal animal = dog;
        Animal animal = cat;
        girl.play(animal);
    }
}
