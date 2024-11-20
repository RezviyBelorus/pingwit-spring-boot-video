package com.pingwit.part_47.controller;

import com.pingwit.part_46.dto.UserDto;
import com.pingwit.part_47.service.UserServicePart47;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/hibernate/part47/user")
@RequiredArgsConstructor
public class UserControllerPart47 {

    private final UserServicePart47 userService;

    @GetMapping
    public List<UserDto> findAll() {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public UserDto find(@PathVariable Long id) {
        return userService.find(id);
    }

    @PostMapping
    public UserDto save(UserDto user, MultipartFile image) throws IOException {
        return userService.save(user, image);
    }

    @DeleteMapping("/{id}")
    public Long delete(@PathVariable Long id) {
        return userService.delete(id);
    }
}
