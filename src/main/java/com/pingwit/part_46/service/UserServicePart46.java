package com.pingwit.part_46.service;

import com.pingwit.part_46.dto.AvatarDto;
import com.pingwit.part_46.dto.UserDto;
import com.pingwit.part_46.entity.UserPart46;
import com.pingwit.part_46.repository.UserRepositoryPart46;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServicePart46 {

    private final UserRepositoryPart46 userRepository;
    private final AvatarService avatarService;
    private final UserConverter userConverter;

    public List<UserDto> findAll() {
        return userRepository.findAll().stream()
                .map(userConverter::toDto)
                .map(this::getAvatarImage)
                .toList();
    }

    public UserDto find(Long id) {
        return userRepository.findById(id)
                .map(userConverter::toDto)
                .map(this::getAvatarImage)
                .orElse(null);
    }

    public UserDto save(UserDto userDto, MultipartFile image) throws IOException {
        AvatarDto avatarDto = avatarService.save(userDto.getAvatar(), image);
        userDto.setAvatar(avatarDto);

        UserPart46 entity = userConverter.toEntity(userDto);

        UserPart46 savedEntity = userRepository.save(entity);

        UserDto dto = userConverter.toDto(savedEntity);
        return getAvatarImage(dto);
    }

    @SneakyThrows
    private UserDto getAvatarImage(UserDto userDto) {
        AvatarDto updateAvatarDto = avatarService.getImage(userDto.getAvatar());
        userDto.setAvatar(updateAvatarDto);
        return userDto;
    }

    public Long delete(Long id) {
        userRepository.deleteById(id);
        return id;
    }
}
