package com.holddie.jvm.oom.direct;

import sun.nio.ch.DirectBuffer;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.SocketTimeoutException;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.concurrent.CountDownLatch;

/**
 * 分配 1G 的 DirectByteBuffer，等待用户输入后，复制为 null，之后阻塞持续观察堆外内存变化
 * 结论：变量虽然置为了 null，但内存依旧持续占用。
 */
public class WriteByDirectByteBuffer {
    public static void main(String[] args) throws IOException, InterruptedException {
//        allocateNotGC();
//        allocateWithGC();
//        allocateWithClean();
//        allocateMmapWithReflecte();
//        fillMmap1000G();
    }

    private static void fillMmap1000G() throws IOException, InterruptedException {
        File data = new File("/tmp/data.txt");
        data.createNewFile();
        FileChannel channel = new RandomAccessFile(data, "rw").getChannel();
        for (int i = 0; i < 1000; i++) {
            channel.map(FileChannel.MapMode.READ_WRITE, 0, 1024 * 1024 * 1024);
        }
        System.out.println("map finish");
        new CountDownLatch(1).await();
    }

    private static void allocateMmapWithReflecte() throws IOException, InterruptedException {
        File file = new File("/tmp/data.txt");
        file.createNewFile();
        FileChannel channel = new RandomAccessFile(file, "rw").getChannel();
        MappedByteBuffer map = channel.map(FileChannel.MapMode.READ_WRITE, 0, 1024 * 1024 * 1024);
        System.in.read();
        MmapUtil.clean(map);
        new CountDownLatch(1).await();
    }

    private static void allocateWithGC() throws IOException, InterruptedException {
        ByteBuffer buffer = ByteBuffer.allocateDirect(1024 * 1024 * 1024);
        System.in.read();
        buffer = null;
        System.gc();
        new CountDownLatch(1).await();
    }

    private static void allocateNotGC() throws IOException, InterruptedException {
        ByteBuffer buffer = ByteBuffer.allocateDirect(1024 * 1024 * 1024);
        System.in.read();
        buffer = null;
        new CountDownLatch(1).await();
    }

    private static void allocateWithClean() throws IOException, InterruptedException {
        ByteBuffer buffer = ByteBuffer.allocateDirect(1024 * 1024 * 1024);
        System.in.read();
        ((DirectBuffer) buffer).cleaner().clean();
        new CountDownLatch(1).await();
    }

}
