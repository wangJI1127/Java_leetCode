package javaLearn.bio;
/**
 * @Author: 王吉
 * @Description：
 * @Date: Created in  2019/9/16
 * @Modifited By:
 */

import java.io.IOException;
import java.net.Socket;
import java.util.Date;

/**
 * @ClassName:BIO通信模型
 * @Description:
 * @Author:ASUS
 * @Date:2019/9/16 14:06
 * @Version:1.0
 **/
public class BIO通信模型客户端 {

    public static void main(String[] args) {
        new Thread(() -> {
            try {
                Socket socket = new Socket("127.0.0.1", 3333);
                while (true){
                    try {
                        socket.getOutputStream().write((new Date() + ":hello world").getBytes());
                    }catch (Exception e){
                    }
                }
            }catch (IOException e){
            }
        }).start();
    }
}
