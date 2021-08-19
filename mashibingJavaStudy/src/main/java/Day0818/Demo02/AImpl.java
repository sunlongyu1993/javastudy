package Day0818.Demo02;

/**
 * @author 孙珑瑜
 * @version 210818
 * 接口的实现类
 */
public class AImpl implements TestInterface,TestInterfaceb{
    @Override
    public void atest() {
        System.out.println("实现接口A中的抽象方法atest");

    }

    @Override
    public void btest(int a) {
        System.out.println("实现接口A中的抽象方法btest");
    }


    @Override
    public void ctest(String name) {
        System.out.println("实现接口A中的抽象方法ctest");
    }

    @Override
    public void dtest(Double dd) {
        System.out.println("实现接口A中的抽象方法dtest");
    }

    @Override
    public void etest() {
        System.out.println("重写接口中的非抽象方法-default方法");
    }
}
