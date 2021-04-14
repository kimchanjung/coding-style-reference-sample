package com.commerce.practice.ordersystem.services;

import com.commerce.practice.ordersystem.entity.User;
import com.commerce.practice.ordersystem.repositories.UserRepository;
import org.springframework.stereotype.Service;

import javax.persistence.Temporal;
import javax.transaction.Transactional;
import java.util.Optional;

/**
 * Created by kimchanjung on 2021-04-14 오후 5:57
 */
@Transactional
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findMe(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 회원입니다"));
    }
}
