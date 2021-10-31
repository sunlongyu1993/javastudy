package Day1025.Demo03;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

/**
 * @author 孙珑瑜
 * @version 211029
 * 发送方
 */
public class TesetSend {
    public static void main(String[] args) throws IOException {
        System.out.println("学生上线了");
        DatagramSocket ds = new DatagramSocket(1234);//1、准备套接字,指定发送方的端口
        //2、准备数据包
        Scanner sc = new Scanner(System.in);//从键盘接收
        System.out.println("学生：");
        String str = sc.next();
//        String str = "老师，你好";
        byte[] bytes = str.getBytes();
        /**dgp：
         * 第一个字段：传送数据转为字节数组
         * 第二个字段：字节数组的长度
         * 第三个字段：封装接收方的ip
         * 第四个字段：指定接收方的端口号
         */
        DatagramPacket dgp = new DatagramPacket(bytes,bytes.length,
                InetAddress.getByName("localhost"),2222);
        //3、向老师发送消息
        ds.send(dgp);

        //4、接受老师的消息
        //有一个空的数据包，用来接收老师传来的数据包
        byte[] b = new byte[1024];
        DatagramPacket dataStudent= new DatagramPacket(b,b.length);
        //5、接受对方的数据包，然后放入我们的db数据包中填充
        ds.receive(dataStudent);//接受完毕后，dataStudent 中就填充数据了
        //6、取出数据
        byte[] data = dataStudent.getData();
        String strdata = new String(data,0,dataStudent.getLength());
        System.out.println("老师对我说:"+strdata);


        //关闭资源
        ds.close();


    }
}
