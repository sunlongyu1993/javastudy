package com.testfan.javastudy.Day0323.Demo02;

/**
 * @author 孙珑瑜
 * @version 20210323
 * 异常处理：throw关键字学习
 */
public class ThrowStudy {
    public static void main(String[] args) {
//        int[] arr = null;
        int[] arr = {1,2,4};
        int e = getElement(arr, 5);
        System.out.println(e);

    }
    public static int getElement(int[] arr,int index){
        if (arr ==null){
            throw new NullPointerException("传递的数组的值是null");
        }
        //对传递过来的参数index 进行合法性校验
        if(index<0 || index> arr.length-1){
            throw new ArrayIndexOutOfBoundsException("传递的索引超出了数组的使用范围");
        }
        int ele = arr[index];
        return ele;
    }
}
