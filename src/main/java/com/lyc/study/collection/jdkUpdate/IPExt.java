package com.lyc.study.collection.jdkUpdate;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * #### 1.需要准备的资源
 ```
 链接：https://pan.baidu.com/s/1qYzFyWG 密码：zdrj

 ```
 #### 2.访问GitHub 下载IPExt.java
 ```
 https://github.com/17mon/java
 指定资源路径
 ```
 #### 3.编辑修改好的IPExt.java 代码如下
 ```
 */

/**
 * @Author: liyuanchi
 * @Description:
 * @Date: 16:23 2017/12/20
 */
public class IPExt {
    public static void main(String[] args) {
        IPExt.load("H:\\loveapp\\codebase\\17mon\\17monipdb.datx");

        System.out.println(Arrays.toString(IPExt.find("8.8.8.8")));
        System.out.println(Arrays.toString(IPExt.find("118.28.8.8")));
        System.out.println(Arrays.toString(IPExt.find("255.255.255.255")));
    }

    public static boolean enableFileWatch = false;

    private static int offset;
    private static int[] index = new int[65536];
    private static ByteBuffer dataBuffer;
    private static ByteBuffer indexBuffer;
    private static Long lastModifyTime = 0L;
    private static File ipFile ;
    private static ReentrantLock lock = new ReentrantLock();

    public static void load(String filename) {
        ipFile = new File(filename);
        load();
        if (enableFileWatch) {
            watch();
        }
    }

    public static void load(String filename, boolean strict) throws Exception {
        ipFile = new File(filename);
        if (strict) {
            int contentLength = Long.valueOf(ipFile.length()).intValue();
            if (contentLength < 512 * 1024) {
                throw new Exception("ip data file error.");
            }
        }
        load();
        if (enableFileWatch) {
            watch();
        }
    }

    public static String[] find(String ip) {
        String[] ips = ip.split("\\.");
        int prefix_value = (Integer.valueOf(ips[0]) * 256 + Integer.valueOf(ips[1]));
        long ip2long_value = ip2long(ip);
        int start = index[prefix_value];
        int max_comp_len = offset - 262144 - 4;
        long tmpInt;
        long index_offset = -1;
        int index_length = -1;
        byte b = 0;
        for (start = start * 9 + 262144; start < max_comp_len; start += 9) {
            tmpInt = int2long(indexBuffer.getInt(start));
            if (tmpInt >= ip2long_value) {
                index_offset = bytesToLong(b, indexBuffer.get(start + 6), indexBuffer.get(start + 5), indexBuffer.get(start + 4));
                index_length = ((0xFF & indexBuffer.get(start + 7)) << 8) + (0xFF & indexBuffer.get(start + 8));
                break;
            }
        }

        byte[] areaBytes;

        lock.lock();
        try {
            dataBuffer.position(offset + (int) index_offset - 262144);
            areaBytes = new byte[index_length];
            dataBuffer.get(areaBytes, 0, index_length);
        } finally {
            lock.unlock();
        }

        return new String(areaBytes, Charset.forName("UTF-8")).split("\t", -1);
    }

    private static void watch() {
        Executors.newScheduledThreadPool(1).scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                long time = ipFile.lastModified();
                if (time > lastModifyTime) {
                    load();
                }
            }
        }, 1000L, 5000L, TimeUnit.MILLISECONDS);
    }

    private static void load() {
        lastModifyTime = ipFile.lastModified();
        lock.lock();
        try {
            dataBuffer = ByteBuffer.wrap(getBytesByFile(ipFile));
            dataBuffer.position(0);
            // indexLength
            offset = dataBuffer.getInt();
            byte[] indexBytes = new byte[offset];
            dataBuffer.get(indexBytes, 0, offset - 4);
            indexBuffer = ByteBuffer.wrap(indexBytes);
            indexBuffer.order(ByteOrder.LITTLE_ENDIAN);

            for (int i = 0; i < 256; i++) {
                for (int j = 0; j < 256; j++) {
                    index[i * 256 + j] = indexBuffer.getInt();
                }
            }
            indexBuffer.order(ByteOrder.BIG_ENDIAN);
        } finally {
            lock.unlock();
        }
    }

    private static byte[] getBytesByFile(File file) {
        FileInputStream fin = null;
        byte[] bs = new byte[new Long(file.length()).intValue()];
        try {
            fin = new FileInputStream(file);
            int readBytesLength = 0;
            int i;
            while ((i = fin.available()) > 0) {
                fin.read(bs, readBytesLength, i);
                readBytesLength += i;
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            try {
                if (fin != null) {
                    fin.close();
                }
            } catch (IOException e){
                e.printStackTrace();
            }
        }

        return bs;
    }

    private static long bytesToLong(byte a, byte b, byte c, byte d) {
        return int2long((((a & 0xff) << 24) | ((b & 0xff) << 16) | ((c & 0xff) << 8) | (d & 0xff)));
    }
    private static int str2Ip(String ip)  {
        String[] ss = ip.split("\\.");
        int a, b, c, d;
        a = Integer.parseInt(ss[0]);
        b = Integer.parseInt(ss[1]);
        c = Integer.parseInt(ss[2]);
        d = Integer.parseInt(ss[3]);
        return (a << 24) | (b << 16) | (c << 8) | d;
    }

    private static long ip2long(String ip)  {
        return int2long(str2Ip(ip));
    }

    private static long int2long(int i) {
        long l = i & 0x7fffffffL;
        if (i < 0) {
            l |= 0x080000000L;
        }
        return l;
    }
}

/**
 * ```
 #### 4，编辑好之后在类路径下找到2个class文件。把这两个class文件替换之前的类路径下的class文件。
 #### 5,修改q.jsp.修改内容为
 ```
 static {
 IP.load("/home/qmdev/app/apache-tomcat-8.5.9/webapps/ROOT/WEB-INF/lib/ipip_net_lib.datx");
 }
 注意：以上的文件目录必须要存在。
 ```
 #### 6，启动tomcat访问q.jsp
 ```
 ./start.sh
 curl http://localhost:8080/q.jps
 ```
 #### 7.查看日志,看IP是否解析成功
 ```
 tail -f catalina.out
 ```
 #### 8.伪造IP请求头
 ```
 curl -H "X-Forwarded-For:
 180.169.31.6,
 115.198.130.26
 223.72.103.91
 111.85.26.178
 223.104.130.64
 49.81.232.158
 114.224.166.168 " http://localhost:8080/q.jsp
 说明，指定多个IP地址访问q.jsp， IP用逗号隔开

 ```
 ### 重复第七步骤看这些IP是否被成功解析

 ## 总结
 ```
 1.不够细致，没发现q.jsp中的目录下没有文件。

 2.在编辑IPExt.java时候出现项目类路径问题。以至于第一次导入的Class文件是错误的
 */
