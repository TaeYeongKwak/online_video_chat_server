package com.videochat.online.auth.controller;

import com.videochat.online.auth.dto.LoginRequestDTO;
import com.videochat.online.auth.dto.SignupRequestDTO;
import com.videochat.online.global.dto.APIResponseDTO;
import com.videochat.online.user.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "2. Auth")
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/auth")
public class AuthController {

    private final UserService userService;

    @ApiOperation(value = "회원 로그인")
    @PostMapping(value = "/login")
    public APIResponseDTO login(@RequestBody LoginRequestDTO loginRequestDTO){
        return APIResponseDTO.success();
    }

    @ApiOperation(value = "회원 가입")
    @PostMapping(value = "/signup")
    public APIResponseDTO signup(@RequestBody SignupRequestDTO signupRequestDTO){
        userService.createUser(signupRequestDTO);
        return APIResponseDTO.success();
    }
}
