package com.javatechie.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import java.io.Serializable;


@Data
@AllArgsConstructor
@NoArgsConstructor
@RedisHash("UserInfo")
public class UserInfo implements Serializable {

    private @Id int id;
    private @Indexed String name;
    private @Indexed  String email;
    private @Indexed  String password;
    private @Indexed  String roles;
}
