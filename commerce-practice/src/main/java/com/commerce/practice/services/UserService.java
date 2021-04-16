package com.commerce.practice.services;

import com.commerce.practice.entity.User;

/**
 * Created by kimchanjung on 2021-04-14 오후 5:56
 */
public interface UserService {
    User findMe(Long id);
}
