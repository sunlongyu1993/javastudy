package Day0728;

/**
 * @author 孙珑瑜
 * @version 210731
 */
public class MainTest {
    public static void main(String[] args) {
        Person person1 = new Person();
        person1.name="sly1";
        person1.age=17;
        person1.height=180;
        person1.weight=70;

        Person person2= new Person();
        person2.name="sly2";
        person2.age=18;
        person2.height=190;
        person2.weight=80;

        System.out.println(person1.name);
        System.out.println(person2.name);

        person1.eat();
        person2.sleep("教室");
        String str = person1.intruduce();
        System.out.println(str);
    }

}
