package com.neo.util;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 匹配正则方法
 *
 * @author fubin
 * TIME 2016-09-20 17:10
 * VERSION 1.0
 */
public class RegexUtils {
    /**
     * 字符串非空判断
     *
     * @param str 参数
     * @return 是否为空布尔值
     */
    public static boolean isnull(String str) {
        if (str != null && !str.equals("")) {
            return false;
        }
        return true;
    }

    /**
     * 日期非空判断
     *
     * @param date 参数
     * @return 是否为空布尔值
     */
    public static boolean isnull(Date date) {
        if (date != null && !date.equals("")) {
            return false;
        }
        return true;
    }

    /**
     * 日期数字判断
     *
     * @param num 参数
     * @return 是否为空布尔值
     */
    public static boolean isnull(Integer num) {
        if (num != null) {
            return false;
        }
        return true;
    }

    /**
     * 对象非空判断
     *
     * @param obj 参数
     * @return 是否为空布尔值
     */
    public static boolean isnull(Object obj) {
        if (obj != null && !obj.equals("")) {
            return false;
        }
        return true;
    }

    /**
     * 时间比较方法
     * 前面时间比后面时间小为true
     * 前面时间比后面时间大为false
     *
     * @param time1 起始时间
     * @param time2 结束时间
     * @return 验证成功返回true，验证失败返回false
     */
    public static boolean timeCompare(Date time1, Date time2) {
        if (time1.getTime() > time2.getTime()) {
            return false;
        }
        return true;
    }

    /**
     * 验证Email
     *
     * @param email email地址，格式：zhangsan@zuidaima.com，zhangsan@xxx.com.cn，xxx代表邮件服务商
     * @return 验证成功返回true，验证失败返回false
     */
    public static boolean checkEmail(String email) {
        String regex = "\\w[-\\w.+]*@([A-Za-z0-9][-A-Za-z0-9]+\\.)+[A-Za-z]{2,14}";
        return Pattern.matches(regex, email);
    }

    /**
     * 验证手机号
     *
     * @param mobile 手机号 11位 13，14，15，17，18开头
     * @return 验证成功返回true，验证失败返回false
     */
    public static boolean checkMobile(String mobile) {
        String regex = "0?(13|14|15|17|18)[0-9]{9}";
        return Pattern.matches(regex, mobile);
    }

    /**
     * 验证qq号
     *
     * @param qq qq号 5-11位
     * @return 验证成功返回true，验证失败返回false
     */
    public static boolean checkQQ(String qq) {
        String regex = "[1-9]([0-9]{4,10})";
        return Pattern.matches(regex, qq);
    }

    /**
     * 验证userNo
     *
     * @param userNo userNo 2-9位字母数字组合
     * @return 验证成功返回true，验证失败返回false
     */
    public static boolean checkUserNo(String userNo) {
        String regex = "^[a-zA-z][a-zA-Z0-9_]{2,9}$";
        return Pattern.matches(regex, userNo);
    }

    /**
     * 验证password
     *
     * @param password password 6-22位字母数字组合 可以纯数字 可以纯字母 可以混合 允许` & * .特殊符号
     * @return 验证成功返回true，验证失败返回false
     */
    public static boolean checkPassword(String password) {
        String regex = "^[\\@A-Za-z0-9\\^\\&\\*\\.\\~]{6,22}$";
        return Pattern.matches(regex, password);
    }

    /**
     * 验证是否是数字
     *
     * @param number number 验证是否是数字
     * @return 验证成功返回true，验证失败返回false
     */
    public static boolean checkNumber(String number) {
        String regex = "[0-9]\\d*";
        return Pattern.matches(regex, number);
    }

    /**
     * 正整数
     *
     * @param number 验证是否为正整数
     * @return 验证成功返回true，验证失败返回false
     */
    public static boolean checkPositive(String number){
        String regex = "^[1-9]\\d*|0$";
        return Pattern.matches(regex, number);
    }
    /**
     * 验证日期（年月日）
     *
     * @param ymd ymd 年月日 例如：1989-11-12
     * @return 验证成功返回true，验证失败返回false
     */
    public static boolean checkDateYMD(String ymd) {
        String regex = "([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})-(((0[13578]|1[02])-(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)-(0[1-9]|[12][0-9]|30))|(02-(0[1-9]|[1][0-9]|2[0-8])))";
        return Pattern.matches(regex, ymd);
    }

    /**
     * 验证日期（年月日时分秒）
     *
     * @param date date 年月日 例如：1989-11-12 11：11：11
     * @return 验证成功返回true，验证失败返回false
     */
    public static boolean checkDate(String date) {
        String regex = "\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}";
        return Pattern.matches(regex, date);
    }

    /**
     * 验证日期（年月日时分秒）
     *
     * @param date date 年月日 例如：1989-11-12 11：11：11
     * @return 验证成功返回true，验证失败返回false
     */
    public static boolean checkDateTime(String date) {
        String regex = "\\d{4}-\\d{2}-\\d{2}";
        return Pattern.matches(regex, date);
    }


    /**
     * 验证数字和字母组合
     *
     * @param string date 年月日 例如：asdas13131
     * @return 验证成功返回true，验证失败返回false
     */
    public static boolean checkString(String string) {
        String regex = "^[a-zA-Z0-9]+$";
        return Pattern.matches(regex, string);
    }

    /**
     * 验证经度正则
     *
     * @param longitude 经度 -180 +180之间
     * @return 验证成功返回true，验证失败返回false
     */
    public static boolean checkLongitude(Double longitude) {
        String longit = String.valueOf(longitude);
        String regex = "(?:[0-9]|[1-9][0-9]|1[0-7][0-9])\\.[0-9]*|180";
        return Pattern.matches(regex, longit);
    }

    /**
     * 验证纬度正则
     *
     * @param latitude 经度 -90 +90之间
     * @return 验证成功返回true，验证失败返回false
     */
    public static boolean checkLatitude(Double latitude) {
        String lati = String.valueOf(latitude);
        String regex = "(?:[0-9]|[1-8][0-9])\\.[0-9]*|90";
        return Pattern.matches(regex, lati);
    }


    /**
     * 逗号连接字符串验证  111,a111,b111,c1111_1
     *
     * @param str 逗号连接字符串
     * @return 验证成功返回true，验证失败返回false
     */
    public static boolean checkCommaStr(String str) {
        String regex = "^[A-Za-z0-9_]+(,[A-Za-z0-9_]+)*$";
        return Pattern.matches(regex, str);
    }

    public static boolean checkhhmmss(String str){
        String regex = "^([0-1]?[0-9]|2[0-3]):([0-5][0-9]):([0-5][0-9])$";
        return Pattern.matches(regex, str);
    }
    public static boolean checkName(String str){
        String regEx = "[`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(str);
        return m.find();
    }
}