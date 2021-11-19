package Day1119.Demo02;

/**
 * @author 孙珑瑜
 * @version 211119
 * 可以作为类的实例的种类
 */
public class ClassIntation {
    /**
     * 类：内部类，外部类
     * 接口
     * 注解
     * 数组
     * 基本数据类型
     * void
     * @param args
     */
    public static void main(String[] args) {
        Class<Person> c1 = Person.class;//类可以作为类的实例
        Class<Comparable> c2 = Comparable.class;//接口可以作为类的实例
        Class<Override> c3 = Override.class;//注解可以作为类的实例
        Class<? extends int[]> c4 = new int[]{1, 2, 3}.getClass();//数组可以作为类的实例
        Class<Integer> c5 = int.class;//基本数据类型可以作为类的实例
        Class<Void> c6 = void.class;//void 可以作为类的实例

    }

}
