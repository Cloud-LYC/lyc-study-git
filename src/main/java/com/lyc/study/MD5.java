package com.lyc.study;

import java.security.MessageDigest;

/**
 * @Auther: liyuanchi
 * @Mail: liyuanchi@meituan.com
 * @DateTime: 2018/1/11 18:05
 * @Description:
 * @Project:
 */
public class MD5 {
    private MD5() {}

    public final static String getMessageDigest(byte[] buffer) {
        char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
        try {
            MessageDigest mdTemp = MessageDigest.getInstance("MD5");
            mdTemp.update(buffer);
            byte[] md = mdTemp.digest();
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            return null;
        }
    }

    public static String getMessageDigest(String message) {
        MessageDigest messageDigest = null;
        StringBuffer md5StrBuff = new StringBuffer();
        try {
            messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.reset();
            messageDigest.update(message.getBytes("UTF-8"));

            byte[] byteArray = messageDigest.digest();
            for (int i = 0; i < byteArray.length; i++)
            {
                if (Integer.toHexString(0xFF & byteArray[i]).length() == 1){
                    md5StrBuff.append("0").append(Integer.toHexString(0xFF & byteArray[i]));
                }
                else{
                    md5StrBuff.append(Integer.toHexString(0xFF & byteArray[i]));
                }
            }
        } catch (Exception e) {
            throw new RuntimeException();
        }
        /**
         * 字母大写
         */
        return md5StrBuff.toString().toUpperCase();
    }

    public static void main(String[] args) {
        byte[] msg = new byte[123123];
        System.out.println(getMessageDigest(msg));

        System.out.println(getMessageDigest(getMessageDigest(msg)));
    }
}
