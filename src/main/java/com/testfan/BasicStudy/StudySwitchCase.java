package com.testfan.BasicStudy;

/**
 * @author 孙珑瑜
 * @version 20200929
 */
public class StudySwitchCase {
    public static void main(String[] args) {
        // 判断上下左右方向
        String direction = "up";
        switch (direction.toLowerCase()){
            case "up":
                System.out.println("上");
                break;
            case "down":
                System.out.println("下");
                break;
            case "left":
                System.out.println("左");
                break;
            case "right":
                System.out.println("右");
                break;
            default:
                System.out.println("除了case里的情况外才会执行此case");
                break;
        }




//        if (direction.equals("up")) {
//            System.out.println("上");
//        } else if (direction.equals("down")) {
//            System.out.println("下");
//        } else if (direction.equals("left")) {
//            System.out.println("左");
//        } else if (direction.equals("right")) {
//            System.out.println("右");
//        }




    }
}
