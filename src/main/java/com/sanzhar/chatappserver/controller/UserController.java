package com.sanzhar.chatappserver.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller("/users")
public class UserController {

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public @ResponseBody String getUsers() {

    return "test...";
    }
}
