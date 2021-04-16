package com.commerce.practice.ordersystem.services.impl;

import com.commerce.practice.ex.ResourceNotFoundException;
import com.commerce.practice.ordersystem.entity.User;
import com.commerce.practice.ordersystem.repositories.UserRepository;
import com.commerce.practice.ordersystem.services.UserService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

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

    /**
     * 원래는 세션의 유저 정보를 가져와서 찾는 로직임
     * 로그인 구현이 없으므로 1번회원을 디풀트로 가져온다
     */
    @Override
    public User findMe(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> ResourceNotFoundException.notFound("업소"));
    }
}
