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
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ServerSocket ss = new ServerSocket(8888);//1、创建套接字

        Socket s = ss.accept();//阻塞流程，等待接收客户端的数据
        InputStream is = s.getInputStream();//输入流，接受客户端数据
        ObjectInputStream ois = new ObjectInputStream(is);

        //读取客户端传入的数据
        UserInformation user = (UserInformation) ois.readObject();
        //校验客户端传入的用户名以及密码
        Boolean flag = false;
        if(user.getName().equals("sly")&& user.getPwd().equals("123123")){
            flag =true;
        }
        //向客户端发送数据
        OutputStream os = s.getOutputStream();
        DataOutputStream dos = new DataOutputStream(os);
        dos.writeBoolean(flag);

        //关闭资源
        dos.close();
        os.close();
        ois.close();
        is.close();
        s.close();
        ss.close();
    }
}
