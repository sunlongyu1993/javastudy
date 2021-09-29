package Day0928;

/**
 * @author 孙珑瑜
 * @version 210929
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
                product.setBrand("费列罗");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                product.setName("巧克力");
            }
            else {
                product.setBrand("哈尔滨");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                product.setName("啤酒");
            }
            //打印生产信息
            System.out.println("生产者生产了："+product.getBrand()+"------"+product.getName());
        }
    }
}
