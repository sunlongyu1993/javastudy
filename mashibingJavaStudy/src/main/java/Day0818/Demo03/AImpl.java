package Day0818.Demo03;

/**
 * @author 孙珑瑜
 * @version 210820
 */
public class AImpl implements TestinterfaceA{
    @Override
    public void atest() {
        System.out.println("实现接口中的抽象方法");
    }

    @Override
    public void bdefault() {
        System.out.println("重写接口中的非抽象方法");
    }
}
