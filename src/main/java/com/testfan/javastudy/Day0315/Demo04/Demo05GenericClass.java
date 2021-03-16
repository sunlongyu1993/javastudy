package com.testfan.javastudy.Day0315.Demo04;

/**
 * @author 孙珑瑜
 */
public class Demo05GenericClass {
    public static void main(String[] args) {
        GenericClass genericClass = new GenericClass();
        genericClass.setName("zifuchuan");
        Object name = genericClass.getName();
        System.out.println(name);

        GenericClass<String> ge = new GenericClass<>();
        ge.setName("aaaa");
        String name1 = ge.getName();
        System.out.println(name1);

        GenericClass<Integer> gec = new GenericClass<>();
        gec.setName(1);
        Integer name2 = gec.getName();
        System.out.println(name2);
    }

}
