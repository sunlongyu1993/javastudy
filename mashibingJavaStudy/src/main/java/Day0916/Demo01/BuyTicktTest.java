package Day0916.Demo01;

/**
 * @author 孙珑瑜
 * @version 210916
 * 买火车票的线程
 */
public class BuyTicktTest extends Thread{
    //带参的构造器，线程的名字作为窗口的名字，直接打印
    public BuyTicktTest(String name){
        super(name); //调用父类的构造器，将名字传入，可以设置线程的名字
    }

    // 所有人都抢这10张票,所以加static,让票共享
    static int ticktNum =10;

    @Override
    public void run() {
        //每个窗口后有100个人排队买票
        for (int i = 1; i <=100 ; i++) {
//                if(ticktNum>0){//只有当ticktNum剩余票大于0，才能被抢
//                    //每次买了1张票后，车票都减少1张：ticktNum--
//                    System.out.println("我从"+this.getName()+"窗口买到了从北京到山东的第"+ticktNum--+"张车票");
//                }
            buytickt();
        }
    }
    public static synchronized void buytickt(){
        if(ticktNum>0){//只有当ticktNum剩余票大于0，才能被抢
            //每次买了1张票后，车票都减少1张：ticktNum--
            System.out.println("我从"+Thread.currentThread().getName()+"窗口买到了从北京到山东的第"+ticktNum--+"张车票");
        }
    }
}
