package com.example.user_manager.Controller.UserController;

import com.example.user_manager.Communicator.AuthDto;
import com.example.user_manager.Communicator.AuthenticationCommunicator;
import com.example.user_manager.Dto.UserProfileDto;
import com.example.user_manager.Service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/user/edit")
@RequiredArgsConstructor
@Slf4j
@RestController
public class UserEditController {
    private final AuthenticationCommunicator authentication;
    private final UserService service;

    /* 유저의 프로필 변경 (사진, 닉네임) */
    @PostMapping("/profile")
    public ResponseEntity editUserProfile(@RequestBody UserProfileDto dto, @RequestHeader("Authorization") String jwt) {
        AuthDto user = authentication.authentication(jwt);
        if(user == null) {
            return ResponseEntity.badRequest().body("Unauthorized JWT.");
        }

        // 유저 프로필 변경 결과
        Boolean result = service.editProfile(dto, user.getUserId());

        if (result) {
            return ResponseEntity.ok().body("유저 프로필 변경에 성공했습니다.");
        } else {
            return ResponseEntity.badRequest().body("유저 프로필 변경에 실패했습니다.");
        }
    }

    /* 유저의 Category List 설정 */
    @PostMapping("/category-list")
    public ResponseEntity editCategoryList(@RequestBody UserProfileDto dto, @RequestHeader("Authorization") String jwt) {
        AuthDto user = authentication.authentication(jwt);
        if(user == null) {
            return ResponseEntity.badRequest().body("Unauthorized JWT.");
        }

        // Category List 설정 결과
        Boolean result = service.editCategoryList(dto, user.getUserId());

        if (result) {
            return ResponseEntity.ok().body("유저 프로필 변경에 성공했습니다.");
        } else {
            return ResponseEntity.badRequest().body("유저 프로필 변경에 실패했습니다.");

        }
    }
}