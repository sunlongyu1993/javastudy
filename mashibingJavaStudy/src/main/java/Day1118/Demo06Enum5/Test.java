package Day1118.Demo06Enum5;

/**
 * @author 孙珑瑜
 * @version 211118
 */
public class Test {
    public static void main(String[] args) {
//        Person p1 = new Person("sly",18,Gender.女);
        Person p1 = new Person();
        p1.setName("sly2");
        p1.setAge(18);
        p1.setSex(Gender.女);
        System.out.println(p1);

    }
}
