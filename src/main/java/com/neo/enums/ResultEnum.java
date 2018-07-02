package com.neo.enums;

/**
 * Created by zy on 2016/9/5.
 * 返回信息枚举
 */
public enum ResultEnum {


    /** 成功枚举构造函数 */
    SECCUESS("0000", "成功"),

    /** 程序报错枚举构造函数 */
    PROGRAM_ERROR("0001","程序异常"),

    /**参数报错枚举构造函数 */
    PARAM_ERROR("0002","参数异常"),

    /**未登录*/
    NOT_LOGIN("0003","未登录"),

    /**token错误*/
    TOKEN_ERROR("0004","Token异常"),

    /** 没有权限*/
    NO_PERMISSIONS("0005","没有权限"),

    /** 登录名或密码错误*/
    LOGIN_ERROR("0006","登录失败"),

    /** 申请记录*/
   APPLY_ERROR("0007","申请失败"),

    /** 登录成功*/
    SIGN_SECCUESS("0008","登录成功"),

    /**使用状态*/
    USE_STATUS("0009","使用中");
    /**返回码*/
    private String retCode;
    /**成功与失败*/
    private String retInfo;

    public String getRetInfo() {
        return retInfo;
    }

    public void setRetInfo(String retInfo) {
        this.retInfo = retInfo;
    }


    public String getRetCode() {
        return retCode;
    }

    public void setRetCode(String retCode) {
        this.retCode = retCode;
    }


    ResultEnum(String retCode, String retInfo) {
        this.retCode = retCode;
        this.retInfo = retInfo;
    }
}
