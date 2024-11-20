package com.pingwit.part_47.service;

import com.pingwit.part_46.dto.AvatarDto;
import com.pingwit.part_46.dto.UserDto;
import com.pingwit.part_47.entity.UserPart47;
import com.pingwit.part_47.repository.UserRepositoryPart47;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class UserServicePart47 {

    private final UserRepositoryPart47 userRepository;
    private final AvatarServicePart47 avatarService;
    private final UserConverterPart47 userConverter;

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

        UserPart47 entity = userConverter.toEntity(userDto);

        UserPart47 savedEntity = userRepository.save(entity);

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
