package LeetCodeDemo;

import java.util.Arrays;

public class Test0906 {
    //有序数组的平方
    public static int[] Test01(int[]a){
        int[] b=new int[a.length];
        for (int i = 0; i < a.length; i++) {

            Arrays.sort(a);
            System.out.println(a[i]);
        }
        return a;
    }

    public static void main(String[] args) {
        int[] a={-1,2,-3,4};
        int[] aa = Test01(a);
        for (int i : aa) {
            System.out.println(aa[i]);
        }
    }
}
