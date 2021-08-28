package Day0825.Demo01;

/**
 * @author 孙珑瑜
 * @version 210825
 */
public class StringBuilderTest {
    public static void main(String[] args) {
        StringBuilder StringBuilder = new StringBuilder();
        StringBuilder stringBuilder2= new StringBuilder(3);
        StringBuilder stringBuilder3= new StringBuilder("abc");
        stringBuilder3.append("def");
        System.out.println(stringBuilder3 );
        

    }
}
