package Day0817.Demo03;

/**
 * @author 孙珑瑜
 * @version 210817
 * 简单工厂模式
 */
public class PetStore {
    public static Animal getPet(String petname){
        Animal an = null;
        if("猫".equals(petname)){
            an = new Cat();
        }
        if("狗".equals(petname)){
            an =new Dog();
        }
        return an;
    }
}
