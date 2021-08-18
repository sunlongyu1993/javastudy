package Day0816.Demo01;

/**
 * @author 孙珑瑜
 * @version 210817
 */
public class Person {
    private  int age;
    private String name;
    private double height;
    int num=20;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public Person() {
    }

    public Person(int age, String name, double height) {
        this.age = age;
        this.name = name;
        this.height = height;
    }
    public void sleep(){
        System.out.println("可以睡觉");
    }
    public void eat(){
        System.out.println("父类中的可以吃饭");
    }
}
