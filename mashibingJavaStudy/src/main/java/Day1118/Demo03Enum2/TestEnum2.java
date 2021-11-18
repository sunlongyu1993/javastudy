package Day1118.Demo03Enum2;

/**
 * @author 孙珑瑜
 * @version 211118
 * 枚举测试类
 */
public class TestEnum2 {
    public static void main(String[] args) {
        Season winter =Season.WINTER;
        System.out.println(winter);
        System.out.println(Season.class.getSuperclass().getName());
        // Season.class 获取Season的字节码
        //getSuperclass 获取父类
        // getName()获取名字

    }
}
