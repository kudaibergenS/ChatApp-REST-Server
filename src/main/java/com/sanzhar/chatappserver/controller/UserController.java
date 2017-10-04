package com.sanzhar.chatappserver.controller;

import com.sanzhar.chatappserver.model.User;
import com.sanzhar.chatappserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/auth/get", method = RequestMethod.GET)
    public @ResponseBody User authorize(@RequestAttribute("user") User user) {

        return user;
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public @ResponseBody List<User> test() {

        return userService.getAllUsers();
    }

}
