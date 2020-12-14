package com.testfan.BasicStudy;

/**
 * @author 孙珑瑜
 * @version 0930
 */
public class StudyFor {
    public static void main(String[] args) {
//        for (int i = 0;i <10;i++){
//            System.out.println(i);
//        }
//
//        int a = 0 ;
//        while (a <10){
//            System.out.println(a);
//            a++;
//
//        }
//        for (int i = 0; i <10 ; i++) {
//            if(i==8){
//                System.out.println("小偷");
//                break;
//            }
//            System.out.println(i+"不是小偷");
//        }
        for (int i = 0; i <10 ; i++) {
            if(i%2==1){
                System.out.println(i +"没有背课文");
                continue;
            }
            System.out.println(i+"过");
        }
    }
}
