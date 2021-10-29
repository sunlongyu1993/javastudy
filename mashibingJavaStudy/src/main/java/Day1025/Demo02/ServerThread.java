package Day1025.Demo02;

import java.io.*;
import java.net.Socket;

/**
 * @author 孙珑瑜
 * @version 211028
 * 服务的线程
 */
public class ServerThread extends Thread{
    InputStream is  =null;
    ObjectInputStream ois =null;
    OutputStream os = null;
    DataOutputStream dos = null;
    Socket s = null;
    public ServerThread(Socket s){
        this.s = s;
    }

    @Override
    public void run() {
        try {
            is = s.getInputStream();//输入流，接受客户端数据
            ois = new ObjectInputStream(is);

            //读取客户端传入的数据
            UserInformation user = (UserInformation) ois.readObject();
            //校验客户端传入的用户名以及密码
            Boolean flag = false;
            if(user.getName().equals("sly")&& user.getPwd().equals("123123")){
                flag =true;
            }
            //向客户端发送数据
            os = s.getOutputStream();
            dos = new DataOutputStream(os);
            dos.writeBoolean(flag);
        }
        catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        finally {
            //关闭资源
            try {
                dos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                ois.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
//            try {
//                s.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            try {
//                ss.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
        }
    }

}
