package Day0818.Demo03;

/**
 * @author 孙珑瑜
 * @version 210820
 */
public class MainTest {
    public static void main(String[] args) {
        AImpl a = new AImpl();
        a.atest();//调用实现类中的抽象方法
        a.bdefault();//调用实现类中的非抽象方法
        TestinterfaceA.statictest();//接口中静态方法的调用
    }
}
