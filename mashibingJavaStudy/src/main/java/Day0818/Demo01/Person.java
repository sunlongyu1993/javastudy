package Day0818.Demo01;

/**
 * @author 孙珑瑜
 * @version 210818
 * 抽象方法抽象类
 */
public abstract class Person {
    public void eat(){
        System.out.println("吃饭饭");
    }
    public abstract void say();
//    {
//        System.out.println("说话");
//    }
    public abstract void sleep();

}
