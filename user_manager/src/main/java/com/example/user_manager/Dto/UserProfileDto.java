package com.example.user_manager.Dto;

import com.example.user_manager.JpaClass.UserTable.UserEntity;
import lombok.Data;

import java.util.Base64;

@Data
public class UserProfileDto {
    private String userId;
    private String nickName;
    private String image;
    private String categoryList;

    static public UserProfileDto userEntryToDto(UserEntity userEntity) {
        UserProfileDto userProfileDto = new UserProfileDto();

        userProfileDto.setUserId(userEntity.getUserId());
        userProfileDto.setNickName(userEntity.getNickName());
        userProfileDto.setImage(Base64.getEncoder().encodeToString(userEntity.getImage()));

        return userProfileDto;
    }
}