package Day0816.Demo01;

/**
 * @author 孙珑瑜
 * @version 210817
 */
public class Student extends Person{
    private int sno;//
    int num=10;

    public int getSno() {
        return sno;
    }

    public void setSno(int sno) {
        this.sno = sno;
    }

    public void study(){
        System.out.println("学生可以学习");
    }

    @Override
    public void eat(){
        System.out.println("子类中的eat方法");
    }
    public void atest(){
        System.out.println(num);
        System.out.println(this.num);
        System.out.println(super.num);
        /*super.*/eat();
        this.eat();
        super.eat();
    }
}
