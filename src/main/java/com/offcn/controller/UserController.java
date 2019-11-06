package com.offcn.controller;

import com.offcn.dao.UserDao;
import com.offcn.entity.User;
import com.offcn.mapper.UserMapper;
import com.offcn.pojo.MUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author lijun
 * @date 2019/11/5 10:26
 */
@RestController
public class UserController {
    @Autowired
    private UserDao userDao;
    @Autowired
    private UserMapper userMapper;
    @RequestMapping("/user/list2")
    public List<User> showUserList(){

        return userDao.findAll();
    }
    @RequestMapping("/user/list3")
    public List<MUser> getUserList3(){

        return userMapper.getUserList();
    }

}
