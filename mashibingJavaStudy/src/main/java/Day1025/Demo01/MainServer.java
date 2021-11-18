package Day1025.Demo01;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author 孙珑瑜
 * @version 211026
 * 服务端
 */
public class MainServer {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(8888);//创建套接字，指定服务器的端口
        Socket ap = ss.accept();//阻塞方法，等待接收客户端数据
        InputStream is = ap.getInputStream();// 感受到的操作流
        DataInputStream dis = new DataInputStream(is);
        //读取客户端发来的数据
        System.out.println("客户端发来的数据为:"+dis.readUTF());
        //向客户端输出一句话——操作流——输出流
        OutputStream ops = ap.getOutputStream();
        DataOutputStream dos = new DataOutputStream(ops);
        dos.writeUTF("客户端你好，我是服务端，已经收到你消息");

        //关闭流+关闭网络资源
        dos.close();
        ops.close();
        dis.close();
        is.close();
        ap.close();
        ss.close();
    }
}
