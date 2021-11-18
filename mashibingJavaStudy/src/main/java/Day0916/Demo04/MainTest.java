package Day0916.Demo04;

/**
 * @author 孙珑瑜
 * @version 210916
 */
public class MainTest {
    public static void main(String[] args) {
        // 有3个途径去抢票，就创建3个线程对象
        BuyTicktTest b1 = new BuyTicktTest("窗口1");
        b1.start();//线程1启动

        BuyTicktTest b2 = new BuyTicktTest("窗口2");
        b2.start();//线程2启动

        BuyTicktTest b3 = new BuyTicktTest("窗口3");
        b3.start();//线程3启动
    }
}
