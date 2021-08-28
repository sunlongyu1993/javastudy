package Day0825.Demo01;

/**
 * @author 孙珑瑜
 * @version 210828
 */
public class Test01 {
    public static void main(String[] args) {
        Integer i1 = new Integer(6);
        Integer i2 = new Integer(12);
        System.out.println(i1.compareTo(i2));//-1

        Integer i3 = new Integer(12);
        Integer i4 = new Integer(12);
        System.out.println(i3.equals(i4));//true

        Integer i5 =12;
        Integer i6 =12;
        System.out.println(i5.equals(i6));//true

        Integer i7 =12;
        int i = i7.intValue();
        System.out.println(i);

        int i8 = Integer.parseInt("123");
        System.out.println(i8);

    }
}
