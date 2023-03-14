package com.example.api.service;

import com.example.api.entity.User;
import com.example.api.error.UserExistsException;
import com.example.api.error.UserNotFoundException;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    User registerUser(User newUser) throws UserExistsException;

    User findUserByEmail(String email) throws UserNotFoundException;
}
