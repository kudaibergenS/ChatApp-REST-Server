package com.sanzhar.chatappserver.repository;


import com.sanzhar.chatappserver.model.User;

import java.util.List;

public interface UserRepository {

    public List<User> getAllUsers();
}
