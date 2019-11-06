package com.offcn.controller;

import com.offcn.dao.UserDao;
import com.offcn.entity.User;
import com.sun.rowset.internal.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class PageController {

    @Autowired
    private UserDao userDao;

    @Value("${page.rows}")
    private Integer rows;

    @RequestMapping("get/user/list")
    public String getUserList(Model model){

        List<User> userList=userDao.findAll();
        model.addAttribute("userList",userList);
        return "user";
    }

    @ResponseBody
    @RequestMapping("page/rows")
    public Map getUser(){
        Map map=new HashMap();
        map.put("rows",rows);
        return map;
    }

}
