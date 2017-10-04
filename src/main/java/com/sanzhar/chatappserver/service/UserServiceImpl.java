package com.sanzhar.chatappserver.service;

import com.sanzhar.chatappserver.model.User;
import com.sanzhar.chatappserver.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public User getUserByLoginAndPassword(String login, String password) {
        return userRepository.getUserByLoginAndPassword(login, password);
    }

    @Transactional
    public User getUserById(int id) {
        return userRepository.getUserById(id);
    }

    @Transactional
    public List<User> getAllUsers() {

        return userRepository.getAllUsers();
    }
}
