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
    public static void main(String[] args)  {
        Socket s = null;//1、创建套接字
        OutputStream os=null;
        ObjectOutputStream oos =null;
        InputStream is = null;
        DataInputStream dis = null;
        try {
            s = new Socket("10.18.224.143",8888);
            //用户名+密码
            Scanner sc = new Scanner(System.in);
            System.out.println("请输入用户名");
            String name = sc.next();
            System.out.println("请输入密码：");
            String pwd = sc.next();
            //将用户名和密码封装成对象
            UserInformation userInformation =new UserInformation(name,pwd);

            os = s.getOutputStream();//向服务器发送数据
            oos = new ObjectOutputStream(os);
            oos.writeObject(userInformation);

            //接受服务器数据
            is = s.getInputStream();
            dis = new DataInputStream(is);
            boolean str = dis.readBoolean();
            if(str){
                System.out.println("登录成功");
            }
            else {
                System.out.println("登录失败，请重新输入用户名或者密码");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            //关闭资源
            try {
                dis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                oos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                s.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }




    }
}
