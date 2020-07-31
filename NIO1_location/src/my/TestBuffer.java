package my;

import org.junit.Test;

import java.nio.ByteBuffer;

/**
 * @author 孟享广
 * @create 2020-07-31 10:09 上午
 */
public class TestBuffer {
    @Test
    public void test3(){
        ByteBuffer buffer = ByteBuffer.allocateDirect(1024);
        System.out.println(buffer.isDirect());

    }
    @Test
    public void test2(){
        String str = "abcde";
        ByteBuffer buf = ByteBuffer.allocate(1024);
        buf.put(str.getBytes());
        buf.flip();
        byte[] bytes = new byte[buf.limit()];

        buf.get(bytes, 0 ,2);
        System.out.println(new String(bytes));
        System.out.println(buf.position());

        buf.mark();

        buf.get(bytes, 2, 2);
        System.out.println(new String(bytes, 2, 2));
        System.out.println(buf.position());

        buf.reset();
        System.out.println(buf.position());

        if (buf.hasRemaining()){
            System.out.println(buf.remaining());
        }



    }
        @Test
        public void test1(){
            String str = "abcde";
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            System.out.println("---allocate----");
            System.out.println(buffer.position());
            System.out.println(buffer.limit());
            System.out.println(buffer.capacity());

            buffer.put(str.getBytes());

            System.out.println("---put----");
            System.out.println(buffer.position());
            System.out.println(buffer.limit());
            System.out.println(buffer.capacity());

            buffer.flip();
            System.out.println("---flip----");
            System.out.println(buffer.position());
            System.out.println(buffer.limit());
            System.out.println(buffer.capacity());

            byte[] bytes = new byte[buffer.limit()];
            buffer.get(bytes);
            System.out.println(new String(bytes));
            System.out.println(buffer.position());
            System.out.println(buffer.limit());
            System.out.println(buffer.capacity());

            buffer.rewind();
            System.out.println(buffer.position());
            System.out.println(buffer.limit());
            System.out.println(buffer.capacity());

            buffer.clear();
            System.out.println(buffer.position());
            System.out.println(buffer.limit());
            System.out.println(buffer.capacity());

        }
}
