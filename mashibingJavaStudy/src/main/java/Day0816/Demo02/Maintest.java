package Day0816.Demo02;

/**
 * @author 孙珑瑜
 * @version 210816
 */
public class Maintest {
    public static void main(String[] args) {
        Boy boy = new Boy("sly",18);
        Girl girl = new Girl("lm",18);
        girl.love(boy);
        girl.m=new Mom();
        girl.wechat();
    }
}
