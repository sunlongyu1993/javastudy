package Day0829Collection.fanxing;

/**
 * @author 孙珑瑜
 * @version 210915
 */
public class DemoTest1 {
    public static void main(String[] args) {
        Demo01 demo01 = new Demo01();
        demo01.a("aaa");
        demo01.a(123);
        demo01.a(new String[]{"abc"});

        Demo01<String> demo02 = new Demo01<>();
        demo02.a("aaa");
        demo02.a("bec");

        Demo01zi zi = new Demo01zi();
        zi.a("aaa");
    }
}
