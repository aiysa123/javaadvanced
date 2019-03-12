package com.xiaomiao.test;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressTest {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress address = InetAddress.getByName("time-A.timefreq.bldrdoc.gov");
        byte[] addressBytes = address.getAddress();
        //数组是length属性，而字符串测试length()方法
        StringBuffer sbf = new StringBuffer();
        sbf.append("IP为");
        int adres = 0;
        for (int i = 0; i < addressBytes.length; i++) {
            //如果字节数组中的某个字节大于128的话，将会导致输出来的数字是负数，应此我把我的IP地址中超过128的加上256，便没问题了
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
