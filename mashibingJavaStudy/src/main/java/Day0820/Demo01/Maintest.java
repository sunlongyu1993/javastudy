package Day0820.Demo01;

import java.util.Scanner;

/**
 * @author 孙珑瑜
 * @version 210820
 * 面向对象练习题
 */
public class Maintest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请选择要制作的披萨,1是培根披萨,2是水果披萨");
        int choice = sc.nextInt();//你的选择
        switch (choice) {
            case 1:
                System.out.println("请输入培根的克数");
                System.out.println("请输入培根的大小");
                System.out.println("请输入培根的价格");

//                BaconPizz baconPizz = new BaconPizz("培根披萨", 10, 20.0, "金枪鱼");
//                System.out.println(baconPizz.getAll());
                break;
            case 2:
                System.out.println("请输入水果的种类");
                System.out.println("请输入培根的大小");
                System.out.println("请输入培根的价格");
//                FruitPizz fruitPizz = new FruitPizz("黄桃披萨", 8, 100, 300.01);
//                System.out.println(fruitPizz.getAll());
                break;
            default:
                System.out.println("请输入正确的数字");
                break;
        }


    }
}
