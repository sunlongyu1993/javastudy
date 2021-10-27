package Day1025.Demo01;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;

/**
 * @author 孙珑瑜
 * @version 211025
 */
public class MainTest1 {
    public static void main(String[] args) throws UnknownHostException {
//        InetAddress ia = InetAddress.getByName("localhost");
//        System.out.println(ia);
//        InetAddress ia2 = InetAddress.getByName("127.0.0.1");
//        System.out.println(ia2);
//        InetAddress ia3 = InetAddress.getByName("www.baidu.com");
//        System.out.println(ia3.getHostName());
//        System.out.println(ia3.getHostAddress());

        InetSocketAddress isa = new InetSocketAddress("10.18.224.143",8080);
        System.out.println(isa);
        System.out.println(isa.getHostName());// 域名
        System.out.println(isa.getPort());// 端口号

        InetAddress ia = isa.getAddress();
        System.out.println(ia.getHostName());
        System.out.println(ia.getHostAddress());
    }
}
