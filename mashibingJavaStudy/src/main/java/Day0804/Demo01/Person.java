package Day0804.Demo01;

/**
 * @author 孙珑瑜
 * @version 0804
 */
public class Person {
    int id;
    int age;
    String name;
    public Person() {
    }
    public Person(int id, int age, String name) {
//        this.id = id;
//        this.age = age;
        this(id,age);
        this.name = name;
    }

    public Person(int id, int age) {
        // this.id = id;
        this(id);
        this.age = age;
    }
    public Person(int id) {
        this.id = id;
    }

    public void eat(){
        System.out.println("吃饭");
    }
    public void play(){
        eat();
        System.out.println("洗澡");
    }
}
