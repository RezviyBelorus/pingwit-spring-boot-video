package com.pingwit.part_47.service;

import com.pingwit.part_47.repository.UserRepositoryManualControl;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceManualControl {
    private final UserRepositoryManualControl repository;

    @PostConstruct
    private void init() {
//        repository.findWithSpring(1L);
    }
}
