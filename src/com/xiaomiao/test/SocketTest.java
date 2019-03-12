package com.xiaomiao.test;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class SocketTest {
    public static void main(String[] args) throws IOException {

        //����Ĺ��췽����һֱ������ֱ����������Ϊֹ
        try(Socket s = new Socket("time-A.timefreq.bldrdoc.gov",13)){
            InputStream inputStream = s.getInputStream();
            Scanner scanner = new Scanner(inputStream);
            while (scanner.hasNext()) {
                String inLine = scanner.nextLine();
                System.out.println(inLine);
            }
        }

        //�׽��ֳ�ʱ����
        Socket s = new Socket();
        s.setSoTimeout(10000);  //10���ʱ����ʱ����׳�SocketTimeoutException

        //���Խ��������ӵ��׽��ֽ����������
        Socket skt = new Socket();
        skt.connect(new InetSocketAddress("time-A.timefreq.bldrdoc.gov",13),10000);
    }
}
