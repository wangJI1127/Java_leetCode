package javaLearn.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * Java I/O 使用了装饰者模式来实现。以 InputStream 为例，
 *     InputStream 是抽象组件；
 *     FileInputStream 是 InputStream 的子类，属于具体组件，提供了字节流的输入操作；
 *     FilterInputStream 属于抽象装饰者，装饰者用于装饰组件，为组件提供额外的功能。例如 BufferedInputStream 为 FileInputStream 提供缓存的功能。
 *
 *     实例化一个具有缓存功能的字节流对象时，只需要在 FileInputStream 对象上再套一层 BufferedInputStream 对象即可。
 *     FileInputStream fileInputStream = new FileInputStream(filePath);
 *     BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
 */
public class 字节操作_InputStream_OutputStream {

    public static void copyFile(String src, String dist) throws IOException {
        //实现文件复制
        FileInputStream fileInputStream = new FileInputStream(src);
        FileOutputStream fileOutputStream = new FileOutputStream(dist);
        // 1byte 由8位二进制组成， 1k=1024B(Byte)， 1B = 8bit， 下面是每次读入20KB
        byte[] buffer = new byte[20 * 1024];

        int cnt;
        // read() 最多读取 buffer.length 个字节
        // 返回的是实际读取的个数
        // 返回 -1 的时候表示读到 eof，即文件尾
        while ((cnt = fileInputStream.read(buffer, 0, buffer.length)) != -1){
            fileOutputStream.write(buffer, 0, cnt);
        }

        fileInputStream.close();
        fileOutputStream.close();

    }
}
