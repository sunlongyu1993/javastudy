package com.testfan.testngstudy;

import org.testng.annotations.Test;

/**
 * @author 孙珑瑜
 * @version 20201116
 */
// 执行顺序：根据ascall 顺序来执行
public class StudyTest1 {
    @Test//(priority = 1)
    public void test001_f(){
        System.out.println("这是study 的测试用例f");
    }
    @Test//(priority = 2)
    public void test002_a(){
        System.out.println("这是study 的测试用例a");
    }
    @Test//(priority = 3)
    public void test003_b(){
        System.out.println("这是study 的测试用例b");
    }
}
