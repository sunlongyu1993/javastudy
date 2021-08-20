package Day0820.Demo01;

/**
 * @author 孙珑瑜
 * @version 210820
 * 水果披萨
 */
public class FruitPizz extends Pizz{
    private String burdening;//配料
    public FruitPizz() {
    }
    public FruitPizz(String name, int size, double price, String burdening) {
        super(name, size, price);
        this.burdening = burdening;
    }

    public String getBurdening() {
        return burdening;
    }

    public void setBurdening(String burdening) {
        this.burdening = burdening;
    }

    @Override
    public String getAll() {
        return "披萨的名字："+getName()+",披萨的尺寸："+getSize()+",披萨的价格："+getPrice()+",披萨的克数："+burdening;
    }
}
