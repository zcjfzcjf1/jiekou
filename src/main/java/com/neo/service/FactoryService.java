package com.neo.service;

import com.neo.entity.Factory;

import java.util.List;

/**
 * Created by Administrator on 2017/12/9.
 */
public interface FactoryService {

    public Integer factoryCount();

    public List<Factory> getFactory(int page ,int leng) ;

    public Factory findFactoryByFactoryId(String factoryId);

}
