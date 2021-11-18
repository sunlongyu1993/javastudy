package Day1118.Demo05Enum4;

/**
 * @author 孙珑瑜
 * @version 211118
 * 定义枚举类
 */
public enum Season implements TestEnumInterface{
    //枚举_简洁版的
    //外界可以调用，并不能修改

    SPRING{
        @Override
            public void show() {
                System.out.println("这是SPRING");
    }
    },
    SUMMER{
        @Override
        public void show() {
            System.out.println("这是SUMMER");
        }
    } ,
    AUTUME{
        @Override
        public void show() {
            System.out.println("这是AUTUME");
        }
    } ,
    WINTER{
        @Override
        public void show() {
            System.out.println("这是WINTER");
        }
    } ;

//    @Override
//    public void show() {
//        System.out.println("这是枚举类实现的接口");
//    }
}
