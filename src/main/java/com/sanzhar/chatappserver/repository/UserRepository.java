package com.sanzhar.chatappserver.repository;


import com.sanzhar.chatappserver.model.User;

import java.util.List;

public interface UserRepository {

    public User getUserByLoginAndPassword(String login, String password);
    public User getUserById(int id);
    public List<User> getAllUsers();
}
