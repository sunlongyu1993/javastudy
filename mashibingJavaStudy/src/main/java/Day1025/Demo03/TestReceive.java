package Day1025.Demo03;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

/**
 * @author 孙珑瑜
 * @version 211029
 * 接收方
 */
public class TestReceive {
    public static void main(String[] args)  {
        System.out.println("老师上线了：");
        DatagramSocket dgs = null;//创建套接字，指定接收方的端口
        try {
            dgs = new DatagramSocket(2222);
            while (true){
                //2、有一个空的数据包，用来接收 对方传来的数据包
                byte[] b = new byte[1024];
                DatagramPacket dgp= new DatagramPacket(b,b.length);
                //3、接受对方的数据包，然后放入我们的db数据包中填充
                dgs.receive(dgp);//接受完毕后，dgp 中就填充数据了
                //4、取出数据
                byte[] data = dgp.getData();
                String s = new String(data,0,dgp.getLength());
                System.out.println("学生说:"+s);
                if (s.equals("byebye")){
                    System.out.println("学生下线，老师也要下线了。。。");
                    break;
                }

                //老师进行回复
                Scanner sc = new Scanner(System.in);
                System.out.print("老师说：");
                String strTeacher = sc.next();
//        String strTeacher = "同学,你好";
                byte[] bytes = strTeacher.getBytes();
                //封装数据，并且指定学生的ip 和端口号
                DatagramPacket dpTeacher = new DatagramPacket(bytes,bytes.length,
                        InetAddress.getByName("localhost"),1234);
                dgs.send(dpTeacher);
            }
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            // 5、关闭资源
            dgs.close();
        }




    }
}
