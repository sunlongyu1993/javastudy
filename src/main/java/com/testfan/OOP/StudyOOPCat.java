package com.testfan.OOP;

/**
 * @author 孙珑瑜
 * @version 20201010
 */
public class StudyOOPCat {
    public String color;
    public String name;
    public int age;
    public double weight;
    // 实例方法或是对象方法，可以被调用
    // public 访问修饰符
    // void 方法无返回值，这个位置表示的是方法返回值类型
    // catchMouse；方法名称
    // ():表示参数
    public void catchMouse(){
        System.out.println("捉老鼠");
    }
    public void eat(){
        System.out.println("爱吃鱼");
    }
    public String sleep(){
        return "有返回值";
    }
    public int add(){
        int a = 10;
        int b = 20;
        int sum = a+b;
        return sum;
    }
    public int add(int a,int b){
        int sum =a + b;
        return sum;
    }

    public float add(float a,float b){
        float sum =a + b;
        return sum;
    }
    public int add(int a,int b,int c){
        int sum =a + b + c;
        return sum;
    }
    public double add(double a,double b,double c){
        double sum =a + b+c;
        return sum;
    }


    // 构造方法，实例化个体对象时必须制定某些属性活行为
    // 和类名相同;没有返回类型；
    // 不能被调用；
    public StudyOOPCat(int age,double weight,String color){
        this.age=age;
        this.weight = weight;
        this.color= color;
    }
    public StudyOOPCat(double weight,String color,int age){
        this.age=age;
        this.weight = weight;
        this.color= color;
    }
    public StudyOOPCat(int age,double weight){
        this.age=age;
        this.weight = weight;
    }

    public static void main(String[] args) {
        StudyOOPCat cat1 = new StudyOOPCat(11,2,"白色");
        cat1.name= "加菲猫";
        cat1.catchMouse();
        cat1.eat();
//        cat1.age = 11;
//        cat1.color="白色";
//        cat1.weight = 2;

        StudyOOPCat cat2 = new StudyOOPCat(12,3,"黑色");
        cat2.name= "家猫";
//        cat2.age = 12;
//        cat2.color="白色";
//        cat2.weight = 3;
        cat2.catchMouse();
        cat2.eat();

    }
}
