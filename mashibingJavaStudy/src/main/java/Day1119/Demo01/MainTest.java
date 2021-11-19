package Day1119.Demo01;

/**
 * @author 孙珑瑜
 * @version 211119
 */
public class MainTest {
    public static void main(String[] args) {
        String str ="支付宝" ;
        if("微信".equals(str)){
//            new Wechat().payOnline();
            pay(new Wechat());

        }
        if("支付宝".equals(str)){
//            new Alipay().payOnline();
            pay(new Alipay());
        }
        if("招商银行".equals(str)){
            pay(new BankCar());
        }
    }
//    //同一个类中，方法名相同，形参列表不同，重载
//    public static void pay(Wechat wechat){
//        wechat.payOnline();
//    }
//    public static void pay(Alipay alipay){
//        alipay.payOnline();
//    }
//    public static void pay(BankCar bankCar){
//        bankCar.payOnline();
//    }
    public static void pay(Mtwm mtwm){
        mtwm.payOnline();
        //多态，代替上面3个重载的方法。方法形参是接口，具体传入的是接口的实现类
    }

}
