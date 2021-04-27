package com.testfan.javastudy.Day0426.Demo01;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author 孙珑瑜
 * @version 20210426
 * TCP通讯的服务端
 */
public class TCPServerStudy {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8888);
        Socket socker = serverSocket.accept();
        InputStream is = socker.getInputStream();
        byte[] bytes = new byte[1024];
        int len = is.read(bytes);
        System.out.println(new String(bytes,0,len));
        OutputStream os = socker.getOutputStream();
        os.write("收到谢谢".getBytes());

        socker.close();
        serverSocket.close();
    }
}
