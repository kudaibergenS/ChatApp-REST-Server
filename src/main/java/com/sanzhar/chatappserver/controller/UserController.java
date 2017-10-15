package com.sanzhar.chatappserver.controller;

import com.sanzhar.chatappserver.model.User;
import com.sanzhar.chatappserver.service.UserService;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/auth/get", method = RequestMethod.GET)
    public User authorize(@RequestAttribute("user") User user) {

        return user;
    }

    @RequestMapping(value = "/contacts", method = RequestMethod.GET)
    public List<User> getUserContacts(@RequestAttribute("user") User user) {

        return user.getUserContacts();
    }

    @RequestMapping(value = "/image/{uri:.+}", method = RequestMethod.GET)
    public void getImage(@PathVariable("uri") String img_uri, HttpServletRequest request, HttpServletResponse response) throws IOException {
        String uri = "/WEB-INF/resources/images/" + img_uri;

        InputStream in = request.getServletContext().getResourceAsStream(uri);
        response.setContentType(MediaType.IMAGE_PNG_VALUE);
        IOUtils.copy(in, response.getOutputStream());
    }

}