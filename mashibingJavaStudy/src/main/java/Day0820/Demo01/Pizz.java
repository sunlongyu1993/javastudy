package Day0820.Demo01;

/**
 * @author 孙珑瑜
 * @version 210820
 * 披萨父类
 */
public class Pizz {
    //属性
    private String name;//名字
    private int size;//尺寸
    private double price;//价格
    //方法
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Pizz() {
    }

    public Pizz(String name, int size, double price) {
        this.name = name;
        this.size = size;
        this.price = price;
    }

    public String getAll() {
        return "披萨的名字：" + getName() + "\n披萨的尺寸：" + getSize() + "寸\n披萨的价格：" + getPrice();
    }
}
