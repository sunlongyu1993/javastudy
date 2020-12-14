package com.testfan.BasicStudy;

/**
 * @author 孙珑瑜
 * @version 20200930
 */
public class StudyException {
    public static void main(String[] args) {
        int[] a = new int[3];
        try {
            a[0]=1;
            a[1]=2;
            a[2]=3;
            a[3]=4;
            int i = 2/0;
            System.out.println("这是异常之后的代码");

//        }catch (ArithmeticException e){
//            System.out.println("数组越界了"+e);
//            System.out.println("回去");
//            e.printStackTrace();
//        }
//        catch (ArrayIndexOutOfBoundsException f){
//            f.printStackTrace();

        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            System.out.println("数组赋值完成");
        }



    }
}
