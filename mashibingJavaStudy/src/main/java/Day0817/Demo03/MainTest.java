package Day0817.Demo03;

/**
 * @author 孙珑瑜
 * @version 210817
 */
public class MainTest {
    //这是一个main方法
    public static void main(String[] args) {
        Girl girl = new Girl();
        Animal an = PetStore.getPet("猫");
        Animal an2 = PetStore.getPet("狗");
        girl.play(an);
        girl.play(an2);
    }
}
