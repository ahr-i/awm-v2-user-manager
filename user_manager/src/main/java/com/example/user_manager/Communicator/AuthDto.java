package com.example.user_manager.Communicator;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class AuthDto {
    private final String userId;
    private final String nickName;

    private final int rankScore;
    private final byte[] image;
    private final int state;
    private final String provider;
}