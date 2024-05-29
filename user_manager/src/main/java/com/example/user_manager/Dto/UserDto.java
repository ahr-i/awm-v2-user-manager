package com.example.user_manager.Dto;

import com.example.user_manager.JpaClass.UserTable.Oauth2UserEntity;
import com.example.user_manager.JpaClass.UserTable.UserEntity;
import com.example.user_manager.ScreenShotTransfer.ScreenShotTransfer;
import lombok.Data;

@Data
public class UserDto {

    private String nickName;
    private int rankScore;
    private byte[] image;
    private String image_hash;
    private int state;
    private String provider;
    private String userId;
    private String password;

    public static UserDto oauthTransferEntity(Oauth2UserEntity entity) {
        UserDto dto = new UserDto();
        dto.setProvider(entity.getProvider());
        dto.setState(0);
        dto.setNickName(entity.getNickname());
        dto.setRankScore(0);
        dto.setImage(null);
        dto.setProvider(entity.getProvider());
        dto.setUserId(entity.getProviderUserId());
        return dto;
    }

    public static UserDto UserEntityToUserDto(UserEntity entity) {
        UserDto dto = new UserDto();
        dto.setNickName(entity.getNickName());
        dto.setUserId(entity.getUserId());
        dto.setPassword(entity.getPassword());
        dto.setProvider(entity.getProvider());
        dto.setRankScore(entity.getRankScore());
        dto.setState(0);
        dto.setImage(entity.getImage());
        dto.setImage_hash(dto.getImage_hash());
        dto.setNickName(dto.nickName);
        return dto;
    }

    public static UserEntity UserDtoTransferUser(UserDto user) {
        String randomName = CharacterName.getRandomName();
        UserEntity users = new UserEntity();
        users.setUserId(user.getUserId());
        users.setPassword(user.getPassword());
        users.setState(0);
        users.setNickName(randomName);
        users.setRankScore(0);
        users.setImageHash(null);
        users.setImage(ScreenShotTransfer.screenShotTransfer());
        users.setImage(null);
        users.setProvider("AppUser");
        return users;
    }
}