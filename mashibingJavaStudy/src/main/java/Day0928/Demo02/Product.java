package Day0928.Demo02;

/**
 * @author 孙珑瑜
 * @version 211011
 * 商品类
 */
public class Product {
    private String name;//名字
    private String brand;//品牌
    Boolean flag=false;// 设置生产者和消费者的通信标志,true则表示有商品，消费者可消费；false表示无商品，生产者可生产
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getBrand() {
        return brand;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }
    //生产者
    public synchronized void setProduct(String brand,String name){//同步方法，确保生产者和消费者处理的是同一个商品
        if (flag == true){//true则表示有商品，消费者可消费；false表示无商品，生产者可生产
            try {
                wait();//生产者需等待
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //当false表示无商品，生产者可生产
            this.setBrand(brand);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.setName(name);
        //打印生产信息
        System.out.println("生产者生产了："+this.getBrand()+"------"+this.getName());
        flag =true;//重置flag为true，此时有商品，需要消费者消费
        notify();// 通知消费者
        }
    //消费者
    public synchronized void getProduct(){//同步方法，确保生产者和消费者处理的是同一个商品
        if(flag == false){//当flag为false，表示无商品，需要生产者生产
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("消费者消费了："+this.getBrand()+"-----"+this.getName());
        //重置flag为false，此时无商品，需要生产者上传消费
        flag = false;
        notify();
    }
}
