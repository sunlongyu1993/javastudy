package Day1118.demo02Enum;

/**
 * @author 孙珑瑜
 * @version 211118
 * 定义枚举类
 */
public class Season {
    private final String seasonName;//季节名字
    private final String seasonDesc;//描述
    //利用构造器赋值操作
    private Season(String seasonName,String seasonDesc){
        this.seasonDesc =seasonDesc;
        this.seasonName = seasonName;
    }

    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }

    @Override
    public String toString() {
        return "Season{" +
                "seasonName='" + seasonName + '\'' +
                ", seasonDesc='" + seasonDesc + '\'' +
                '}';
    }
    //枚举
    //外界可以调用，并不能修改
    public static final Season SPRING = new Season("春天","春暖花开");
    public static final Season SUMMER = new Season("夏天","烈日炎炎");
    public static final Season AUTUME = new Season("秋天","硕果累累");
    public static final Season WINTER = new Season("冬天","冰天雪地");
}
