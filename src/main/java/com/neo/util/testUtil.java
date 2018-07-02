package com.neo.util;

import com.neo.entity.User;
import com.neo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Administrator on 2018/2/3.
 */
@Component
public class testUtil {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public void test() throws  Exception{
        User u=new User();
        u.setUserName("李四");
        userRepository.save(u);
       int i = 1/0;

        User u1=new User();
        u1.setUserName("李四2");
        userRepository.save(u1);
    }
}
