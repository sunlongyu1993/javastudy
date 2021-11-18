package Day1111;

import java.util.ArrayList;
import java.util.Date;

/**
 * @author 孙珑瑜
 * @version 211111
 * junit注解
 */
public class AnnoTest {

    /**
     *
     * @param a 就餐人数
     * @param b
     */
    public void eat(int a,int b){
        @SuppressWarnings("unused")//抑制警告的注解，需要传入参数-无使用
        int age =10;

        @SuppressWarnings(value = {"unused", "rwatypes"})
        ArrayList arrayList = new ArrayList();


        Date date = new Date();
        System.out.println(date.getDate());
        new Student().study();
        }
    }

