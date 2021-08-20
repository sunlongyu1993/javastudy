package Day0820.Demo01;

/**
 * @author 孙珑瑜
 * @version 210820
 * 培根披萨
 */
public class BaconPizz extends Pizz{
    private double weight;//克数，重量

    public BaconPizz() {
    }

    public BaconPizz(String name, int size, double price, double weight) {
        super(name, size, price);
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String getAll() {
        return  "披萨的名字："+getName()+",披萨的尺寸："+getSize()+",披萨的价格："+getPrice()+",披萨的克数："+weight;
    }
}
