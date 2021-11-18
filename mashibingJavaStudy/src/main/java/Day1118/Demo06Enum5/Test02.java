package Day1118.Demo06Enum5;

/**
 * @author 孙珑瑜
 * @version 211118
 */
public class Test02 {
    public static void main(String[] args) {
        Gender sex = Gender.女;
        switch (sex){
            case 女:
                System.out.println("是女孩");
                break;
            case 男:
                System.out.println("是男孩");
                break;
        }

    }
}
