package Day1105.Demo01;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * @author 孙珑瑜
 * @version 211111
 */
public class MainTest {

    @BeforeAll
    public static void init(){
        System.out.println("测试方法优先执行");
    }

    @AfterAll
    public static void close(){
        System.out.println("测试方法最后执行");
    }

    @Test
    public void testAdd(){
        Calculator calculator = new Calculator();
        int result = calculator.add(10, 20);
//        System.out.println(result);
        Assertions.assertEquals(30,result);
    }
}
