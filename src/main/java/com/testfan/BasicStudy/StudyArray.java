package com.testfan.BasicStudy;

/**
 * @author 孙珑瑜
 * @version 0930
 */
public class StudyArray {
    public static void main(String[] args) {
//        int[] arr = new int[3];
//        arr[0] = 1;
//        arr[1] = 2;
//        arr[2] = 3;
//        System.out.println(arr[0]);
//        System.out.println(arr[1]);
//        System.out.println(arr[2]);
//
//        arr[0] = arr[0]+2;
//        arr[1] = arr[1]+2;
//        arr[2] = arr[2]+2;
//        System.out.println(arr[0]);
//        System.out.println(arr[1]);
//        System.out.println(arr[2]);
//        for (int i = 0; i <arr.length ; i++) {
//            arr[i] = arr[i]+3;
//            System.out.println(arr[i]);
//        }

//        for (int i:arr) {
//            System.out.println(i);
//        }
//
//        int[] arr2 = {5,8,10,2};
//        for (int a :arr2) {
//            System.out.println(a);
//        }

//        String[] str = {"张三","李四","王五","赵六"};
//        for (String s:str) {
//            if(s.startsWith("张")){
//                System.out.println(s);
//                break;
//            }
//        }
//        int[] irr ={16,34,12,53,32,16,10,24};
//        int max = irr[0];
//        int min = irr[0];
//        for (int i:irr) {
//            if(i>max){
//                max = i;
//            }
//        }
//
//        for (int i = 1; i <irr.length ; i++) {
//            if(irr[i]>max){
//                max = irr[i];
//            }
//            if(irr[i]<min){
//                min = irr[i] ;
//            }
//            max= Math.max(max, irr[i]);
//            min= Math.min(min, irr[i]);
//        }
//        System.out.println(max);
//        System.out.println(min);
        //二维数组
//        5,8,10,2
//        6,9,11,3
//        7,10,12,4

        int[][] iirr={{5,8,10,2},{6,9,11,3},{7,10,12,4}};
//        for (int i = 0; i <iirr.length ; i++) {
//            int[] line =iirr[i];
//            System.out.println("line:"+line);
//
//            for (int j = 0; j <line.length ; j++) {
//                System.out.println("line[j]"+line[j]);
//            }
//        }
        for (int i = 0; i < iirr.length; i++) {
            for (int j = 0; j < iirr[i].length; j++) {
                System.out.println(iirr[i][j]);
            }
            System.out.println("===========================");
        }

    }
}
