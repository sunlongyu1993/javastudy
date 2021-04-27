package com.testfan.javastudy.Day0426.Demo01;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @author 孙珑瑜
 * @version 20210426
 * TCP通讯的客户端
 */
public class TCPClientStudy {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1",8888);
        OutputStream os = socket.getOutputStream();
        os.write("你好服务器".getBytes());

        InputStream is = socket.getInputStream();
        byte[] bytes = new byte[1024];
        int len = is.read(bytes);
        System.out.println(new String(bytes,0,len));

        socket.close();

    }
}
