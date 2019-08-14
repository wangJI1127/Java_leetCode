package javaLearn.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 新的输入/输出 (NIO) 库是在 JDK 1.4 中引入的，弥补了原来的 I/O 的不足，提供了高速的、面向块的 I/O。
 *
 * 流与块
 * I/O 与 NIO 最重要的区别是数据打包和传输的方式，I/O 以流的方式处理数据，而 NIO 以块的方式处理数据。
 * 面向流的 I/O 一次处理一个字节数据：一个输入流产生一个字节数据，一个输出流消费一个字节数据。为流式数据创建过滤器非常容易，链接几个过滤器，
 * 以便每个过滤器只负责复杂处理机制的一部分。不利的一面是，面向流的 I/O 通常相当慢。
 * 面向块的 I/O 一次处理一个数据块，按块处理数据比按流处理数据要快得多。但是面向块的 I/O 缺少一些面向流的 I/O 所具有的优雅性和简单性。
 *
 * 通道 Channel 是对原 I/O 包中的流的模拟，可以通过它读取和写入数据。
 * 通道与流的不同之处在于，流只能在一个方向上移动(一个流必须是 InputStream 或者 OutputStream 的子类)，而通道是双向的，可以用于读、写或者同时用于读写。
 * 通道包括以下类型：
 *     FileChannel：从文件中读写数据；
 *     DatagramChannel：通过 UDP 读写网络中数据；
 *     SocketChannel：通过 TCP 读写网络中数据；
 *     ServerSocketChannel：可以监听新进来的 TCP 连接，对每一个新进来的连接都会创建一个 SocketChannel。
 *
 * 缓冲区
 * 发送给一个通道的所有数据都必须首先放到缓冲区中，同样地，从通道中读取的任何数据都要先读到缓冲区中。也就是说，不会直接对通道进行读写数据，而是要先经过缓冲区。
 * 缓冲区实质上是一个数组，但它不仅仅是一个数组。缓冲区提供了对数据的结构化访问，而且还可以跟踪系统的读/写进程。
 * 缓冲区包括以下类型：
 *     ByteBuffer
 *     CharBuffer
 *     ShortBuffer
 *     IntBuffer
 *     LongBuffer
 *     FloatBuffer
 *     DoubleBuffer
 *
 * 缓冲区状态变量
 *     capacity：最大容量；
 *     position：当前已经读写的字节数；
 *     limit：还可以读写的字节数。
 *
 * ① 新建一个大小为 8 个字节的缓冲区，此时 position 为 0，而 limit = capacity = 8。capacity 变量不会改变，下面的讨论会忽略它。
 * ② 从输入通道中读取 5 个字节数据写入缓冲区中，此时 position 为 5，limit 保持不变。
 * ③ 在将缓冲区的数据写到输出通道之前，需要先调用 flip() 方法，这个方法将 limit 设置为当前 position，并将 position 设置为 0。
 * ④ 从缓冲区中取 4 个字节到输出缓冲中，此时 position 设为 4。
 * ⑤ 最后需要调用 clear() 方法来清空缓冲区，此时 position 和 limit 都被设置为最初位置。
 */
public class 文件NIO实例 {
    public static void fastCopy(String src, String dist) throws IOException {
        // 使用 NIO 快速复制文件的实例：
        /* 获得源文件的输入字节流 */
        FileInputStream fin = new FileInputStream(src);
        /* 获取输入字节流的文件通道 */
        FileChannel fcin = fin.getChannel();

        /* 获取目标文件的输出字节流 */
        FileOutputStream fout = new FileOutputStream(dist);
        /* 获取输出字节流的文件通道 */
        FileChannel fcout = fout.getChannel();

        /* 为缓冲区分配 1024 个字节 */
        ByteBuffer buffer = ByteBuffer.allocateDirect(1024);

        while (true) {
            /* 从输入通道中读取数据到缓冲区中 */
            int r = fcin.read(buffer);
            /* read() 返回 -1 表示 EOF */
            if (r == -1) {
                break;
            }
            /* 切换读写 */
            buffer.flip();
            /* 把缓冲区的内容写入输出文件中 */
            fcout.write(buffer);
            /* 清空缓冲区 */
            buffer.clear();
        }
    }
}
