package com.bincoding.nonprofit.service;

import com.bincoding.nonprofit.dto.UserWithoutPass;
import com.bincoding.nonprofit.entity.UserEntity;
import com.bincoding.nonprofit.repository.UserRepository;
import com.bincoding.nonprofit.repository.UserWithoutPassword;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

//    public UserService(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }

    public Optional<UserEntity> findById(int userId) {
        return userRepository.findById(userId);
    }

    public Optional<UserWithoutPass> findWithoutPassById(int userId) {
        return userRepository.findWithoutPassById(userId);
    }

    public Optional<UserEntity> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public List<UserWithoutPass> findAllWithoutPass(){
        return  userRepository.findAllBy();
    }

    public List<UserWithoutPass> findAll(){
        return  userRepository.findAllBy();
    }


    public void deleteByUsername(String username) {

         userRepository.findByUsername(username).ifPresent(userEntity -> userRepository.delete(userEntity));

    }

    public void deleteAll() {
        userRepository.deleteAll();
    }

    public Optional<UserWithoutPass> findWithoutPassByUsername(String username) {
        return userRepository.findWithoutPassByUsername(username);
    }
}
