package com.example.api.service;

import com.example.api.entity.User;
import com.example.api.error.UserExistsException;
import com.example.api.error.UserNotFoundException;
import com.example.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;
    @Override
    public User registerUser(User newUser) throws UserExistsException {
        String email = newUser.getEmail();
        Optional<User> user = userRepository.findByEmail(email);
        if(user.isPresent()){
            throw new UserExistsException("email already taken");
        }
        return userRepository.save(newUser);
    }

    @Override
    public User findUserByEmail(String email) throws UserNotFoundException {
        Optional<User> user = userRepository.findByEmail(email);
        if(user.isEmpty()){
            throw new UserNotFoundException("User not found");
        }
        return user.get();
    }
}
