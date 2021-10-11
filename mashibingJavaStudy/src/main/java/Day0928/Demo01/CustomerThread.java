package Day0928.Demo01;

/**
 * @author 孙珑瑜
 * @version 210929
 * 消费者线程
 */
public class CustomerThread extends Thread{
    private Product product;//共享商品
    //通过构造器将商品传入，保证生产者和消费者中的商品是一个
    public CustomerThread(Product product) {
        this.product = product;
    }

    @Override
    public void run() {
        for (int i = 1; i <=10 ; i++) {//i 是消费的次数
            synchronized (product){//同步代码块,锁住生产者和消费者是处理的1个商品
                System.out.println("消费者消费了："+product.getBrand()+"-----"+product.getName());

            }
        }
    }
}
