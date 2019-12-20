package com.wwh.whblog.module.sys.controller;

import com.wwh.whblog.module.sys.entity.User;
import com.wwh.whblog.module.sys.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    private static Logger log = LogManager.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/getUserById", method = RequestMethod.GET)
    @ResponseBody
    private String getUserById(){
        log.info("comming...");
        //User user = userService.getUserById("1");
        List<User> users = userService.findAll();
        return "success";
    }

    @GetMapping(value = "/aaerror")
    public String toError(){
        return "404";
    }
}
