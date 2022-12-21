package com.videochat.online.user.service;

import com.videochat.online.auth.dto.SignupRequestDTO;
import com.videochat.online.user.dto.UserInfoDTO;
import com.videochat.online.user.entity.User;

public interface UserService {
    public UserInfoDTO getUserInfo(Long userId);
    public User createUser(SignupRequestDTO signupRequestDTO);
}
