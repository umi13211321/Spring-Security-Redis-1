package com.javatechie.repository;

import com.javatechie.entity.UserInfo;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserInfoRepository extends CrudRepository<UserInfo, String> {

    Optional<UserInfo> findByName(String username);

    UserInfo findByUserName(String username);

}
