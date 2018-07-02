package com.neo.service.impl;

import com.neo.entity.RestSResponse;
import com.neo.entity.User;
import com.neo.repository.UserRepository;
import com.neo.service.UserService;
import com.neo.util.LoggerUtils;
import com.neo.util.RandomGUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getUserList() {
        return userRepository.findAll();
    }

    @Override
    public User findUserById(long id) {
        return userRepository.findById(id);
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public void edit(User user) {
        userRepository.save(user);
    }

    @Override
    public void delete(long id) {
        userRepository.delete(id);
    }

//    @Override
//    public void findUserByUserNameAndPassword(User user) {
//        userRepository.findUserByUserNameAndPassword(user);
//    }

    @Override
    @Transactional
    public void findUserByUserNameAndPassword(String userName , String password, RestSResponse rs) {

        User userByUserNameAndPassword = userRepository.findUserByUserNameAndPassword(userName, password);
        if(userByUserNameAndPassword==null){
            LoggerUtils.returnError(rs,"用户名或者密码错误");
             return;
        }

        //修改token
        String token = RandomGUID.generateKey();
        //修改token
        userByUserNameAndPassword.setToken(token);
        userRepository.save(userByUserNameAndPassword);

        LoggerUtils.returnSeccuess(rs,userByUserNameAndPassword);
    }

    @Override
    @Transactional
    public void test() {

        User u=new User();
        u.setUserName("李四");
        userRepository.save(u);
//        int i = 1/0;

        User u1=new User();
        u1.setUserName("李四2");
        userRepository.save(u1);

    }


}


