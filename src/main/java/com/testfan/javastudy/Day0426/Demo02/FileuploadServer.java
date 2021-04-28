package com.testfan.javastudy.Day0426.Demo02;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author 孙珑瑜
 * @version 20210427
 */
public class FileuploadServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8888);
        Socket accept = serverSocket.accept();
        InputStream inputStream = accept.getInputStream();
        File file = new File("D:\\code\\slycode\\maven_project\\src\\main\\java\\com\\testfan\\javastudy\\file\\Serverfile");
        if (!file.exists()){
            file.mkdir();
        }
        FileOutputStream fos = new FileOutputStream(file+"\\1.jpg");
        int len =0;
        byte[] bytes = new byte[1024];
       while ((len = inputStream.read(bytes))!=-1){
           fos.write(bytes,0,len);
       }
       accept.getOutputStream().write("上传成功".getBytes());
       fos.close();
       accept.close();
       serverSocket.close();

    }
}
