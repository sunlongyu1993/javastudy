package Day0818.Demo03;

/**
 * @author 孙珑瑜
 * @version 210819
 */
public interface TestinterfaceA {
    public static final int Num =10;
    public abstract void atest();
    public default void bdefault(){
        System.out.println("父类非抽象方法");
    }
    public static void statictest(){
        System.out.println("接口中的静态方法");
    }

}
