package com.videochat.online.user.controller;

import com.videochat.online.global.dto.APIResponseDTO;
import com.videochat.online.user.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "1. User")
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/user")
public class UserController {

    private final UserService userService;

    @ApiOperation(value = "사용자 정보 상세 조회")
    @GetMapping(value = "/{user-id}")
    public APIResponseDTO getUserInfo(@PathVariable("user-id") Long userId){
        return APIResponseDTO.success(userService.getUserInfo(userId));
    }

}
