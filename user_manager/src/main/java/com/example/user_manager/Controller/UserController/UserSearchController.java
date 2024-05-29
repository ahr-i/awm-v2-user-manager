package com.example.user_manager.Controller.UserController;

import com.example.user_manager.Communicator.AuthDto;
import com.example.user_manager.Communicator.AuthenticationCommunicator;
import com.example.user_manager.Dto.UserProfileDto;
import com.example.user_manager.Service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/user/search")
@RequiredArgsConstructor
@Slf4j
@RestController
public class UserSearchController {
    private final AuthenticationCommunicator authentication;
    private final UserService service;

    /* 성향이 비슷한 유저 3명 추천 */
    @GetMapping("/similar-user")
    public ResponseEntity editUserNickName(@RequestHeader("Authorization") String jwt){
        AuthDto user = authentication.authentication(jwt);
        if(user == null) {
            return ResponseEntity.badRequest().body("Unauthorized JWT.");
        }

        // 추천 유저 결과
        List<UserProfileDto> response = service.searchSimilarUser(user.getUserId());

        if(response != null) {
            return ResponseEntity.ok().body(response);
        } else {
            return ResponseEntity.badRequest().body("관심 일치 유저를 찾을 수 없습니다.");
        }
    }
}