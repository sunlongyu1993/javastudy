package Day0829Collection;

import java.util.*;

/**
 * @author 孙珑瑜
 * @version 210829
 */
public class CollectionTest {
    public static void main(String[] args) {
        /**
         * Collection 常用方法
         * 增加 add(E e)  addAll(Collection<? extends E> c)
         * 删除 clear()  remove(Object o)
         * 修改
         * 查看 iterator() size()
         * 判断 contains(Object o)  equals(Object o)  isEmpty()
         */
        Collection  col = new ArrayList();//接口=实现类，多态
        col.add(18);
        System.out.println("集合是否为空："+col.isEmpty());//false
        col.clear();
        System.out.println("集合是否为空："+col.isEmpty());//false

        col.add(29);
        col.add(59);
        System.out.println("集合是否包含18这个数："+col.contains(18));//true
        System.out.println("集合中的数量是："+col.size());//3


        List integers = Arrays.asList(new Integer[]{11, 13, 15, 26});
        col.addAll(integers);
        System.out.println("集合中的数量是："+col.size());//7
        System.out.println("添加一个集合后，新集合为："+col);//[18, 29, 59, 11, 13, 15, 26]

        System.out.println("是否被删除："+col.remove(29));

        System.out.println("=============================================");

        Collection  col2 = new ArrayList();
        col2.add(29);
        col2.add(59);

        Collection  col3 = new ArrayList();
        col3.add(29);
        col3.add(59);
        System.out.println(col2.equals(col3)); //true ：比较的是value值
        System.out.println(col2 == col3); //false 比较的是地址值

        System.out.println("for循环=============================================");
        for (Object o : col) {
            System.out.println(o );
        }
        System.out.println("iterator循环=============================================");
        Iterator ite = col.iterator();
        while (ite.hasNext()){
            System.out.println(ite.next());
        }


    }
}
