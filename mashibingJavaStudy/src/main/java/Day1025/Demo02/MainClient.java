package Day1025.Demo02;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author 孙珑瑜
 * @version 211027
 * 客户端
 */
public class MainClient {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Socket s = new Socket("10.18.224.143",8888);//1、创建套接字

        //用户名+密码
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名");
        String name = sc.next();
        System.out.println("请输入密码：");
        String pwd = sc.next();
        //将用户名和密码封装成对象
        UserInformation userInformation =new UserInformation(name,pwd);
        OutputStream os = s.getOutputStream();//向服务器发送数据
        ObjectOutputStream oos = new ObjectOutputStream(os);
        oos.writeObject(userInformation);
        //接受服务器数据
        InputStream is = s.getInputStream();
        DataInputStream dis = new DataInputStream(is);
        boolean str = dis.readBoolean();
        if(str){
            System.out.println("登录成功");
        }
        else {
            System.out.println("登录失败，请重新输入用户名或者密码");
        }
        //关闭资源
        dis.close();
        is.close();
        oos.close();
        os.close();
        s.close();

    }
}
