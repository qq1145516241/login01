package com.demo.login.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class StringEncrypt {
    /**
     * 对字符串加密,加密算法使用MD5,SHA-1,SHA-256,默认使用SHA-256
     *
     * @param strSrc
     *            要加密的字符串
     * @return
     */
    public static String Encrypt(String strSrc) {
        MessageDigest md = null;
        String strDes = null;
        byte[] bts = null ;

        byte[] bt = strSrc.getBytes();
        try {
            md = MessageDigest.getInstance("SHA-256");//设置SHA-256加密算法

            md.update(bytesHex(bt).getBytes());

            bts = md.digest();

            for (int i = 0; i < bts.length; i++) {
                strDes += bts[i];
            }

            //调用digest()方法提交后返回
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
        return strDes;
    }

    //将字节数组里的字节转成16进制字符串后拼接返回.
    public static String bytesHex(byte[] bts) {
        String des = "";
        String tmp = null;
        for (int i = 0; i < bts.length; i++) {
            tmp = (Integer.toHexString(bts[i] & 0xFF));
            if (tmp.length() == 1) {
                des += "0";
            }
            des += tmp;
        }
        return des;
    }
}