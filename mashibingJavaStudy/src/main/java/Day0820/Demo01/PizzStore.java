package Day0820.Demo01;

import java.util.Scanner;

/**
 * @author 孙珑瑜
 * @version 210820
 * 披萨制造工厂-生产pizz
 */
public class PizzStore {
    public static Pizz getPizz(int choice) {
        Scanner sc = new Scanner(System.in);
        Pizz pizz = null;
        switch (choice) {
            case 1://1是培根披萨
            {
                System.out.println("请输入培根的克数");
                double weight = sc.nextDouble();
                System.out.println("请输入培根的大小");
                int size = sc.nextInt();
                System.out.println("请输入培根的价格");
                double price = sc.nextDouble();
                pizz = new BaconPizz("培根披萨",size,price,weight);
            }
            break;
            case 2://2是水果披萨
            {
                System.out.println("请输入水果的种类");
                String num = sc.next();
                System.out.println("请输入培根的大小");
                int size = sc.nextInt();
                System.out.println("请输入培根的价格");
                double price = sc.nextDouble();
                pizz = new FruitPizz("水果披萨",size,price,num);
            }
            break;
        }
        return pizz;
    }
}
