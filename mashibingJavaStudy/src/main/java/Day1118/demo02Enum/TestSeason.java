package Day1118.demo02Enum;

/**
 * @author 孙珑瑜
 * @version 211118
 * 测试类
 */
public class TestSeason {
    public static void main(String[] args) {
        Season spring = Season.SPRING;
        Season autumn = Season.AUTUME;
        System.out.println(spring);
        System.out.println(autumn);
        System.out.println("------------------------------");
        System.out.println(spring.getSeasonName());


    }
}
