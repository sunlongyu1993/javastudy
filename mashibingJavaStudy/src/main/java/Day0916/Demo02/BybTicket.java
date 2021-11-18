package Day0916.Demo02;

/**
 * @author 孙珑瑜
 * @version 211012
 *
 */
public class BybTicket implements  Runnable{
    int ticketNum =10;//10张火车票
    @Override
    public void run() {
        for (int i = 1; i <=100 ; i++) {
            synchronized (this){
                if(ticketNum>0){
                    System.out.println("我在窗口"+Thread.currentThread().getName()+"买第"+ticketNum--+"张火车票");
                }
            }

        }
    }
}
