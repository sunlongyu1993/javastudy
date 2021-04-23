package com.testfan.javastudy.Day0417.Demo01;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

/**
 * @author 孙珑瑜
 * @version 20210417
 * 字节输出流写多个字节
 */
public class OutputStreamDemo02 {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("D:\\code\\slycode\\maven_project\\src\\main\\java\\com\\testfan\\javastudy\\Day0417\\Demo01BufferedWriter\\1.txt");
        fos.write(49);//在文件中写入100这个数子，需要3个字节
        fos.write(48);
        fos.write(48);
        //
        byte[] bytes = {65,66,67,68,69};
//        byte[] bytes = {-65,-66,-67,68,69};
        fos.write(bytes);

        fos.write(bytes,1,2);

        byte[] bytes1 = "你好".getBytes();
        System.out.println(Arrays.toString(bytes1));
        fos.write(bytes1);


        fos.close();
    }
}
