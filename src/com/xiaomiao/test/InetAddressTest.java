package com.xiaomiao.test;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressTest {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress address = InetAddress.getByName("time-A.timefreq.bldrdoc.gov");
        byte[] addressBytes = address.getAddress();
        //������length���ԣ����ַ�������length()����
        StringBuffer sbf = new StringBuffer();
        sbf.append("IPΪ");
        int adres = 0;
        for (int i = 0; i < addressBytes.length; i++) {
            //����ֽ������е�ĳ���ֽڴ���128�Ļ������ᵼ��������������Ǹ�����Ӧ���Ұ��ҵ�IP��ַ�г���128�ļ���256����û������
            adres = addressBytes[i];
            if(adres < 0){
                adres = adres + 256;
            }
            sbf.append(adres + ":");
        }
        String result = sbf.toString().substring(0,sbf.length() - 1);
        System.out.println(result);

    }
}
