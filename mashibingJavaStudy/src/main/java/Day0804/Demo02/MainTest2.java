package Day0804.Demo02;

/**
 * @author 孙珑瑜
 * @version 0804
 */
public class MainTest2 {
    int age ;
    static int sid;
    public MainTest2(){};
    public MainTest2(int age){
        this.age=age;
    };
    public void a(){
        System.out.println("普通方法");
        {//普通块限制了局部变量的范围
            int num =10;
        }
    }
    public static void test1(){
        System.out.println("静态方法");
    }
    {
        //构造块
        System.out.println("构造块");
    }
    static {
        System.out.println("静态块");
        System.out.println(sid);
        test1();
    }

    public static void main(String[] args) {
        MainTest2 m1=new MainTest2();
        m1.a();
        MainTest2 m2=new MainTest2();
        m2.a();

    }

}
