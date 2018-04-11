package com.ray.string;

import sun.misc.BASE64Encoder;

import java.security.MessageDigest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StringUtils {

    /**
     * MD5加密 加密失败返回空
     * @param str 要加密的字符串
     * @return
     */
    public static String md5(String str) {
        //确定计算方法
        MessageDigest md5Method= null;
        try {
            md5Method = MessageDigest.getInstance("MD5");
            BASE64Encoder base64en = new BASE64Encoder();
            //加密后的字符串
            String newstr=base64en.encode(md5Method.digest(str.getBytes("utf-8")));
            return newstr;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    /**
     * 日期转换为字符串
     * @param d
     * @param format
     * @return
     */
    public static String dateToStr(Date d, String format){
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(d);
    }

    /**
     * 字符串转换为日期
     * @param str 字符串
     * @param format 日期格式
     * @return 转换后的日期
     * @throws ParseException
     */
    public static Date strToDate(String str, String format) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.parse(str);
    }


}
