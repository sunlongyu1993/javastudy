package Day0818.Demo01;

/**
 * @author 孙珑瑜
 * @version 210818
 * 子类-重写父类中抽象方法
 */
public class Student extends Person{
    @Override
    public void say() {
        System.out.println("子类，重新父类say方法");
    }

    @Override
    public void sleep() {
        System.out.println("睡觉觉");
    }
}
