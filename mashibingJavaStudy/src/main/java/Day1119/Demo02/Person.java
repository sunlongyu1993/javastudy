package Day1119.Demo02;

import java.io.Serializable;

/**
 * @author 孙珑瑜
 * @version 211119
 */
public class Person implements Serializable {
    public String name;
    private int age;//

    private void eat(){
        System.out.println("Person-------eat");
    }
    public void sleep(){
        System.out.println("Person-----------sleep");
    }

}
