package com.sanzhar.chatappserver.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("user")
public class UserController {

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public @ResponseBody Map test() {
        Map user = new HashMap();
        user.put("name", "test");
        user.put("age", 21);

    return user;
    }

}
