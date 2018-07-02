package com.neo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by Administrator on 2017/12/4.
 */
@Entity
public class Factory {

    @Id
    @GeneratedValue
    private long id;


    @Column
    private String factoryId;

    @Column
    private String factoryName;

    @Column
    private String factoryTable;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFactoryId() {
        return factoryId;
    }

    public void setFactoryId(String factoryId) {
        this.factoryId = factoryId;
    }

    public String getFactoryName() {
        return factoryName;
    }

    public void setFactoryName(String factoryName) {
        this.factoryName = factoryName;
    }

    public String getFactoryTable() {
        return factoryTable;
    }

    public void setFactoryTable(String factoryTable) {
        this.factoryTable = factoryTable;
    }
}
