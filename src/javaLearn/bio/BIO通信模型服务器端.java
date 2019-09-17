package javaLearn.bio;
/**
 * @Author: 王吉
 * @Description：
 * @Date: Created in  2019/9/16
 * @Modifited By:
 */

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @ClassName:BIO通信模型服务器端
 * @Description:
 * @Author:ASUS
 * @Date:2019/9/16 14:12
 * @Version:1.0
 **/
public class BIO通信模型服务器端 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(3333);
        // 接收到客户daunt连接请求之后为每个客户端创建一个新的线程进行链路处理
        new Thread(() -> {
            while (true) {
                try {
                    // 阻塞方法获取新的连接
                    Socket socket = serverSocket.accept();

                    // 每一个新的连接都创建一个线程负责读取数据
                    new Thread(() -> {
                        try {
                            int len;
                            byte[] data = new byte[1024];
                            InputStream inputStream = socket.getInputStream();
                            // 按字节流方式读取数据
                            while ((len = inputStream.read(data)) != -1){
                                System.out.println(new String(data, 0, len));
                            }
                        }catch (IOException e){
                        }
                    }).start();
                }catch (IOException e){}
            }
        }).start();

    }
}
