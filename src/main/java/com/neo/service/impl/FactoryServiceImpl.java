package com.neo.service.impl;

import com.neo.entity.Factory;
import com.neo.repository.FactoryRepository;
import com.neo.repository.UserRepository;
import com.neo.service.FactoryService;
import com.neo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2017/12/9.
 */
@Service
public class FactoryServiceImpl  implements FactoryService {


    @Autowired
    private FactoryRepository factoryRepository;

    @Override
    public Integer factoryCount() {
        long count = factoryRepository.count();
        return (int)count;
    }

    @Override
    public List<Factory> getFactory(int page ,int leng) {

        List<Factory> list =factoryRepository.getFactoryAll( page , leng);

        return list;
    }

    @Override
    public Factory findFactoryByFactoryId(String factoryId) {
       Factory f= factoryRepository.findFactoryByFactoryId(factoryId);
        return f;
    }

}
