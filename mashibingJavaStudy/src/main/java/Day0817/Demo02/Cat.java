package Day0817.Demo02;

/**
 * @author 孙珑瑜
 * @version 210817
 */
public class Cat extends Animal {
    int age;
    @Override
    public void shout(){
        System.out.println("我是小猫，我会喵喵喵。。。");
    }
    public void scratch(){
        System.out.println("我是小猫，我会挠人。。。");
    }
}
