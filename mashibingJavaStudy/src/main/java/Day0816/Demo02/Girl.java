package Day0816.Demo02;

/**
 * @author 孙珑瑜
 * @version 210816
 */
public class Girl {
    String name;
    double weight;
    Mom m /*= new Mom()*/;


    public Girl() {
    }

    public Girl(String name, double weight) {
        this.name = name;
        this.weight = weight;
    }
    public void love(Boy b){
        System.out.println("男朋友的名字："+b.name+"男朋友的年龄"+b.age);
        b.buy();
    }
    public void wechat(){
        m.say();
    }
}
