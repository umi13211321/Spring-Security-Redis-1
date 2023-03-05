package com.javatechie.service;

import com.javatechie.entity.UserInfo;

import java.util.Optional;

public interface UserService {
    public String addUser(UserInfo userInfo);

    public Optional<UserInfo> findByName(String username);

}
