package Day0728;

/**
 * @author 孙珑瑜
 * @version 210728
 * 创建一个类
 */
public class Person {
    int age;
    String name;
    double height;
    double weight;

    public void eat(){
        int num =10;
        System.out.println("我喜欢吃饭");
    }
    public void sleep(String address){
        System.out.println("我在"+address+"睡觉");
    }
    public String intruduce(){
        return "我的名字"+name+",我的年龄"+age+",我的身高是："+height+",我的体重是："+weight;
    }
}
