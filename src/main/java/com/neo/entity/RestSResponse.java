package com.neo.entity;

import java.io.Serializable;

/**
 * @author  zy
 * date 2016.9.7
 * Effect 返回结果对象
 */
public class RestSResponse implements Serializable {
    /**返回码*/
    private String retCode;

    /**成功与失败*/
    private String retInfo;

    /**对象*/
    private Object data;

    public String getRetCode() {
        return retCode;
    }

    public void setRetCode(String retCode) {
        this.retCode = retCode;
    }

    public String getRetInfo() {
        return retInfo;
    }

    public void setRetInfo(String retInfo) {
        this.retInfo = retInfo;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

}
