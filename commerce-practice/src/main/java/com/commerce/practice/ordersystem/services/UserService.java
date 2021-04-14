package com.commerce.practice.ordersystem.services;

import com.commerce.practice.ordersystem.entity.User;

import java.util.Optional;

/**
 * Created by kimchanjung on 2021-04-14 오후 5:56
 */
public interface UserService {
    User findMe(Long id);
}
