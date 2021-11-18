package Day0820.Demo02;

/**
 * @author 孙珑瑜
 * @version 210823
 * 饮品类
 */
public class DrinkClass {
    private String name;//名称
    private int price;//价格
    private int size;//大小：中杯，大杯，超大杯
    private int num;//饮品数量
    private Boolean  addice;//是否加冰
    private String remark;//备注

    public DrinkClass() {
    }

    public DrinkClass(String name, int price, int size, int num, Boolean addice, String remark) {
        this.name = name;
        this.price = price;
        this.size = size;
        this.num = num;
        this.addice = addice;
        this.remark = remark;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public Boolean getAddice() {
        return addice;
    }

    public void setAddice(Boolean addice) {
        this.addice = addice;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
    public String orderInfo(){
        return "您购买了"+getName()+":"+getName()+","+getAddice()+",购买的"+getSize()+",购买的数量"+getNum()+"购买的价格"+getPrice();
    }
}
