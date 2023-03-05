package com.javatechie.service;

import com.javatechie.config.UserInfoUserDetails;
import com.javatechie.entity.UserInfo;
import com.javatechie.repository.UserInfoRepository;
import com.javatechie.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserInfoUserDetailsService implements UserDetailsService {

    @Autowired
    private UserInfoRepository userInfoRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<UserInfo> userInfo = userInfoRepository.findByName(username);
        System.out.println("*****"+userInfo.isEmpty());
        System.out.println("*****"+userInfo.getClass());
        System.out.println("*****"+userInfo.toString());

        return userInfo.map(UserInfoUserDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException("user not found " + username));

//        UserInfo userInfo = userInfoRepository.findByUserName(username);
//        System.out.println("*****"+userInfo);
//        Optional<UserInfo> userInfo1 = Optional.ofNullable(userInfo);
//        return userInfo1.map(UserInfoUserDetails::new)
//                .orElseThrow(() -> new UsernameNotFoundException("user not found " + username));

    }
}