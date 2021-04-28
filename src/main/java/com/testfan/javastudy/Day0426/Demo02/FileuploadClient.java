package com.testfan.javastudy.Day0426.Demo02;

import java.io.*;
import java.net.Socket;

/**
 * @author 孙珑瑜
 * @version 20210427
 */
public class FileuploadClient {
    public static void main(String[] args) throws Exception {
        FileInputStream fis = new FileInputStream("D:\\code\\slycode\\maven_project\\src\\main\\java\\com\\testfan\\javastudy\\file\\1.jpg");
        Socket socket = new Socket("127.0.0.1",8888);
        OutputStream os = socket.getOutputStream();

        int len =0;
        byte[] bytes = new byte[1024];
        while ((len =fis.read(bytes))!=-1){
           os.write(bytes,0,len);
        }
        socket.shutdownOutput();
        InputStream is = socket.getInputStream();
        while ((len =fis.read(bytes))!=-1){
            System.out.println(new String(bytes,0,len));
        }
        fis.close();
        socket.close();

    }
}
