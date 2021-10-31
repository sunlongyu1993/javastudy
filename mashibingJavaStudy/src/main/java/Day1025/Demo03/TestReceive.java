package Day1025.Demo03;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

/**
 * @author 孙珑瑜
 * @version 211029
 * 接收方
 */
public class TestReceive {
    public static void main(String[] args) throws IOException {
        System.out.println("老师上线了：");
        DatagramSocket dgs = new DatagramSocket(2222);//创建套接字，指定接收方的端口
        //2、有一个空的数据包，用来接收 对方传来的数据包
        byte[] b = new byte[1024];
        DatagramPacket dgp= new DatagramPacket(b,b.length);
        //3、接受对方的数据包，然后放入我们的db数据包中填充
        dgs.receive(dgp);//接受完毕后，dgp 中就填充数据了
        //4、取出数据
        byte[] data = dgp.getData();
        String str = new String(data);
        System.out.println("学生说:"+str);

        //老师发送消息
        Scanner sc = new Scanner(System.in);
        System.out.println("老师说：");
        String strTeacher = sc.next();
//        String strTeacher = "同学,你好";
        byte[] bytes = strTeacher.getBytes();
        //封装数据，并且指定学生的ip 和端口号
        DatagramPacket dpTeacher = new DatagramPacket(bytes,bytes.length,
                InetAddress.getByName("localhost"),1234);
        dgs.send(dpTeacher);

        // 5、关闭资源
        dgs.close();


    }
}
