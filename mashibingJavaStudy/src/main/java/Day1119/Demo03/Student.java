package Day1119.Demo03;

/**
 * @author 孙珑瑜
 * @version 211119
 */
@MyAnnotation(value = "StudentClass")
public class Student extends Person implements MyInterface {
    //属性
    private int sno;//学号
    double height;//身高
    protected double weight;//体重
    public double score;//成绩
    //方法
    @MyAnnotation(value = "Method-ShowInfo")
    public String ShowInfo(){
        return "我是一名三好学生";
    }
    public String ShowInfo(int a,int b){
        return "重载方法——public权限修饰符方法ShowInfo";
    }
    protected int getSno(){
        return sno;
    }
    private void work(int a){
        System.out.println("Student-----private权限修饰符方法work");
    }
    void happy(){
        System.out.println("Student------default权限修饰符方法happy");
    }


    //构造器
    public Student() {
        System.out.println("空构造器");
    }
    public Student(double height, double weight) {
        this.height =height;
        this.weight =weight;
    }
    private Student(int sno) {
        this.sno = sno;
    }
            Student(int sno, double weight) {
        this.sno = sno;
        this.weight = weight;
    }
    protected Student(int sno,double height, double weight) {
        this.sno =sno;
    }

    @Override
    @MyAnnotation(value = "OverrideMethod")
    public void MyMethod(int a)throws RuntimeException {
        System.out.println("重新了MyInterface接口中的Method的方法");
    }

    @Override
    public String toString() {
        return "Student{" +
                "sno=" + sno +
                ", height=" + height +
                ", weight=" + weight +
                ", score=" + score +
                '}';
    }
}
