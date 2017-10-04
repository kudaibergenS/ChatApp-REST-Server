package com.sanzhar.chatappserver.service;


import com.sanzhar.chatappserver.model.User;

import java.util.List;

public interface UserService {

    public User getUserByLoginAndPassword(String login, String password);
    public User getUserById(int id);
    public List<User> getAllUsers();

}
