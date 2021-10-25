package Day0916.Demo03;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author 孙珑瑜
 * @version 211014
 */
public class MainTest implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        return new Random().nextInt(10);//返回10内的随机数
    }

}
class Test{
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MainTest mainTest = new MainTest();
        FutureTask futureTask = new FutureTask(mainTest);
        Thread t = new Thread(futureTask);
        t.start();

        Object obj = futureTask.get();//获取线程得到的返回值
        System.out.println(obj);

    }
}
