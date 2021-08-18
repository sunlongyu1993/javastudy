package Day0817.Demo03;

/**
 * @author 孙珑瑜
 * @version 210817
 */
public class Dog extends Animal {
    @Override
    public void shout(){
        System.out.println("我是小狗，我会汪汪汪。。。");
    }
    public void guard(){
        System.out.println("我是小狗，我会看家护院");
    }
}
