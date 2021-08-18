package Day0818.Demo02;

/**
 * @author 孙珑瑜
 * @version 210818
 * 子类-重写父类中抽象方法
 */
public class Student extends Person implements TestInterface{
    @Override
    public void say() {
        System.out.println("子类，重新父类say方法");
    }

    @Override
    public void sleep() {
        System.out.println("睡觉觉");
    }

    @Override
    public void atest() {
        System.out.println("先继承再实现atest");
    }

    @Override
    public void btest(int a) {
        System.out.println("先继承再实现btest");

    }
}
