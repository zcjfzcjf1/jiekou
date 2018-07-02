package com.neo.entity;

/**
 * Created by Administrator on 2017/12/9.
 */
public class demo {

    private String id;
    private String a;
    private String b;

    public demo(String id ,String a,String b){
        this.id=id;
        this.a=a;
        this.b=b;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }
}
