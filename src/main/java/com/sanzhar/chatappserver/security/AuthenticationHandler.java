package com.sanzhar.chatappserver.security;


import com.sanzhar.chatappserver.model.User;
import com.sanzhar.chatappserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import sun.misc.BASE64Decoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

public class AuthenticationHandler extends HandlerInterceptorAdapter {

    @Autowired
    private UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String authorization = request.getHeader("Authorization");

        if(authorization != null && authorization.startsWith("Basic")){
            try {
                String encodedUserCredentials = authorization.substring("Basic".length()).trim();
                String decodedUserCredentials = new String(new BASE64Decoder().decodeBuffer(encodedUserCredentials));
                String[] userCredentials = decodedUserCredentials.split(":");
                String userLogin = userCredentials[0];
                String userPassword = userCredentials[1];

                User user = userService.getUserByLoginAndPassword(userLogin, userPassword);

                if(user != null){
                    System.out.println("user: " + user.getLogin() + " is authorized at: " + new Date());
                    request.setAttribute("user", user);
                    response.setStatus(HttpServletResponse.SC_OK);
                    return true;
                } else {
                    System.out.println("user unauthorized");
                    response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                    return false;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        return false;
    }
}
