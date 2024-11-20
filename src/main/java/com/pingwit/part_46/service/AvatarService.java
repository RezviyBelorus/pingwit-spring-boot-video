package com.pingwit.part_46.service;

import com.pingwit.part_46.dto.AvatarDto;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class AvatarService {

    private static final String IMAGES_FOLDER = "src/main/resources/part_46/";

    public AvatarDto save(AvatarDto avatar, MultipartFile image) throws IOException {
        if (image == null) {
            return avatar;
        }

        String fileName = UUID.randomUUID().toString();
        Files.write(Paths.get(IMAGES_FOLDER + fileName), image.getBytes());

        if (avatar == null) {
            avatar = new AvatarDto();
        }
        avatar.setUrl(fileName);

        return avatar;
    }

    public AvatarDto getImage(AvatarDto dto) throws IOException {
        if (dto == null) {
            return dto;
        }

        byte[] image = Files.readAllBytes(Paths.get(IMAGES_FOLDER + dto.getUrl()));
        dto.setImage(image);


        return dto;
    }
}
