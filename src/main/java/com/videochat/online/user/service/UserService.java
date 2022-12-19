package com.videochat.online.user.service;

import com.videochat.online.user.dto.UserInfoDTO;

public interface UserService {
    public UserInfoDTO getUserInfo(Long userId);
}
