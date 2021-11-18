package Day0928.Demo03;

/**
 * @author 孙珑瑜
 * @version 211021
 * 生产者线程
 */
public class ProducerThread extends Thread{
    private Product product;//共享商品
    //通过构造器将商品传入，保证生产者和消费者中的商品是一个
    public ProducerThread(Product product){
        this.product =product;
    }
    @Override //需要将run方法进行重写
    public void run() {//i 是消费的次数
        for (int i = 1; i <=10 ; i++) {//生产10个商品
                if(i %2 ==0){
                    product.setProduct("费列罗","巧克力");
                }
                else {
                    product.setProduct("哈尔滨","啤酒");
                }
        }
    }
}
