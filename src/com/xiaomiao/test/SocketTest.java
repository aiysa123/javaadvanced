package com.xiaomiao.test;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class SocketTest {
    public static void main(String[] args) throws IOException {

        //下面的构造方法会一直阻塞，直到建立连接为止
        try(Socket s = new Socket("time-A.timefreq.bldrdoc.gov",13)){
            InputStream inputStream = s.getInputStream();
            Scanner scanner = new Scanner(inputStream);
            while (scanner.hasNext()) {
                String inLine = scanner.nextLine();
                System.out.println(inLine);
            }
        }

        //套接字超时问题
        Socket s = new Socket();
        s.setSoTimeout(10000);  //10秒后超时，超时后会抛出SocketTimeoutException

        //可以建立无连接的套接字解决阻塞问题
        Socket skt = new Socket();
        skt.connect(new InetSocketAddress("time-A.timefreq.bldrdoc.gov",13),10000);
    }
}
