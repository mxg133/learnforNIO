package my;

import org.junit.Test;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * @author 孟享广
 * @create 2020-07-31 5:14 下午
 */
public class TestBlockingNIO {
    //客户端
    @Test
    public void test1() throws Exception {
        SocketChannel schannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 9898));

        FileChannel inChannel = FileChannel.open(Paths.get("1.jpg"), StandardOpenOption.READ);

        ByteBuffer buf = ByteBuffer.allocate(1024);

        while (inChannel.read(buf) != -1){
            buf.flip();
            schannel.write(buf);
            buf.clear();
        }
        inChannel.close();
        schannel.close();




    }
    //服务端
    @Test
    public void test2() throws Exception {
        ServerSocketChannel ssChannel = ServerSocketChannel.open();
        FileChannel outChannel = FileChannel.open(Paths.get("2.jpg"), StandardOpenOption.WRITE);
        ssChannel.bind(new InetSocketAddress(9898));
        SocketChannel sChannel = ssChannel.accept();
        ByteBuffer buf = ByteBuffer.allocate(1024);

        while (sChannel.read(buf) != -1) {
            buf.flip();
            outChannel.write(buf);
            buf.clear();

        }
        sChannel.close();
        outChannel.close();
        ssChannel.close();




    }

}
