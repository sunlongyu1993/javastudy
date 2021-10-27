package Day1025.Demo01;

import java.io.*;
import java.net.Socket;

/**
 * @author 孙珑瑜
 * @version 211025
 * 客户端
 */
public class MainClient {
    public static void main(String[] args) throws IOException {
        //1、创建套接字，指定服务器ip 和端口
        Socket s = new Socket("10.18.224.143",8888);
        OutputStream os = s.getOutputStream();//向外发送数据，利用输出流OutputStream
        DataOutputStream dos = new DataOutputStream(os);//发送String的方法DataOutputStream
        dos.writeUTF("你好");
        //接受服务端的回应——利用输入流
        InputStream is = s.getInputStream();
        DataInputStream dis = new DataInputStream(is);
        String sr = dis.readUTF();
        System.out.println("服务端对我说："+sr);

        dis.close();
        is.close();
        dos.close();//关闭流+关闭网络资源
        os.close();
        s.close();
    }
}
