package Day0816.Demo02;

/**
 * @author 孙珑瑜
 * @version 210816
 */
public class Boy {
    String name;
    int age;

    public Boy() {
    }

    public Boy(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public void buy(){
        System.out.println("买买买");
    }
}
