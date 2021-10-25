package Day0916.Demo02;

/**
 * @author 孙珑瑜
 * @version 211012
 */
public class MainTest {
    public static void main(String[] args) {

        BybTicket bybTicket = new BybTicket();//定义一个线程对象，共享一个对象，10张票就共享

        Thread thread1 = new Thread(bybTicket,"窗口1");
        thread1.start();

        Thread thread2 = new Thread(bybTicket,"窗口2");
        thread2.start();

        Thread thread3 = new Thread(bybTicket,"窗口3");
        thread3.start();
    }
}
