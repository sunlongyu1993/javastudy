package Day0928;

/**
 * @author 孙珑瑜
 * @version 210929
 */
public class MainTest {
    public static void main(String[] args) {
        Product p  = new Product();//共享商品
        ProducerThread pt = new ProducerThread(p);//生产者
        CustomerThread ct = new CustomerThread(p);//消费者
        //线程启动
        pt.start();
        ct.start();
    }
}
