package com.testfan.javastudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author 孙珑瑜
 * @version 20201224
 */
public class workoutstudy {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("请在控制台输入字符：");
        char c;
        do {
            c = (char) br.read();
        }while (c != 'q');
    }
}
