package com.separttwo.usermanagermicroservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User registerUser(User user) {
        User registeredUser = userRepository.save(user);
        return registeredUser;
    }

    public User getUserById(String id) {
        User user = userRepository.findById(id).orElse(null);
        return user;
    }

    public User authenticateUser(String username, String password) {
        User user = userRepository.findByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        } else {
            return null;
        }
    }
}
