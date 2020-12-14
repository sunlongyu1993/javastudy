package com.testfan.BasicStudy;

/**
 * @author 孙珑瑜
 * @version 20200929
 */
public class StudyWhile {
    public static void main(String[] args) {
        //while 括号里循环的条件
        int a = 0;
        int sum = 0;
        while (a <= 100 ) {
            if (a % 2==1&&a % 3 == 0)
            {
                sum += a;
                System.out.println(a);
            }
            a++;
        }
        System.out.println(sum);

        int b = 0;
        int sum2 = 0;
        do {
            if(b% 2==1&&b %3==0){
                sum2 += b;
                System.out.println(b);
            }

            b++;
        }
        while (b <= 100);
        System.out.println(sum2);
    }
}
