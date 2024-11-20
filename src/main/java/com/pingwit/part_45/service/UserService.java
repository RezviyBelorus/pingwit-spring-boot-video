package com.pingwit.part_45.service;

import com.pingwit.part_45.entity.User;
import com.pingwit.part_45.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @PostConstruct
    private void init() {
        userRepository.findAllByName("Egorka");
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }
}
