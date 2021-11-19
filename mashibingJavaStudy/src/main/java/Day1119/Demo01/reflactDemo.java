package Day1119.Demo01;

import java.lang.reflect.Method;

/**
 * @author 孙珑瑜
 * @version 211119
 */
public class reflactDemo {
    public static void main(String[] args) throws Exception {
        //定义一个字符串，用来模拟前台的支付方式
        String str = "Day1119.Demo01.Alipay";//Wechat 的全限定路径

        //反射
        Class<?> aClass = Class.forName(str);
        Object oinstance = aClass.newInstance();
        Method method = aClass.getMethod("payOnline");
        method.invoke(oinstance);

    }
}
