package Day1025.Demo02;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author 孙珑瑜
 * @version 211027
 * 服务端
 */
public class MainServer {
    public static void main(String[] args)  {
        System.out.println("服务器启动了：");
        ServerSocket ss = null;//1、创建套接字
        Socket s =null;
        int count = 0;
        try {
            ss = new ServerSocket(9999);
            while (true){//服务器一直监听客户端发送的数据
                s = ss.accept();//阻塞流程，等待接收客户端的数据
                ServerThread st = new ServerThread(s);//每次的客户端请求 靠线程处理
                st.start();//线程启动
                count++;
                System.out.println("当前是第"+count+"个用户访问我们的服务器,对应的用户是："+s.getInetAddress());
            }

        } catch (IOException  e) {
            e.printStackTrace();
        }
        }

    }

