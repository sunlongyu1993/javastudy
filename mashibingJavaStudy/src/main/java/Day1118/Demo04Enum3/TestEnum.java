package Day1118.Demo04Enum3;

/**
 * @author 孙珑瑜
 * @version 211118
 */
public class TestEnum {
    public static void main(String[] args) {
//        Season spring = Season.SPRING;
//        System.out.println(spring);

        Season[] values = Season.values();
        for (Season value : values) {
            System.out.println(value);
        }
        Season spring = Season.valueOf("SPRING");
        System.out.println(spring);
    }
}
