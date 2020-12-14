package com.testfan.BasicStudy;

/**
 * @author 孙珑瑜
 * @version 20200929
 */
public class StudyIf {
    public static void main(String[] args) {
        //
        int a = 10;
        int b = a%2;
        System.out.println(b);
        if(a%2==0){
            System.out.println("b是偶数");
        }
        else {
            System.out.println("b是奇数");
        }
        int score = 40;
        if(score >=90&& score<=100){
            System.out.println("优秀");
        }
        else if(score >=80){
            System.out.println("良好");
        }
        else if(score >=70){
            System.out.println("一般");
        }
        else if(score >=60){
            System.out.println("及格");
        }
        else if(score>=0) {
            System.out.println("不及格");
        }



    }
}
