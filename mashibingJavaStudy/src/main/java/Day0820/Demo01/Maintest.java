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
        Pizz pizz = PizzStore.getPizz(choice);
        System.out.println(pizz.getAll());
    }
}
