package com.example.user_manager.Controller.UserController;

import com.example.user_manager.Communicator.AuthDto;
import com.example.user_manager.Communicator.AuthenticationCommunicator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@Slf4j
@RestController
public class UserProfileController {
    private final AuthenticationCommunicator authentication;

    @GetMapping("user/profile")
    public ResponseEntity userProFile(@RequestHeader("Authorization") String jwt){
        AuthDto user = authentication.authentication(jwt);
        if(user == null) {
            return ResponseEntity.badRequest().body("Unauthorized JWT.");
        }

        return ResponseEntity.ok().body(user);
    }
}
