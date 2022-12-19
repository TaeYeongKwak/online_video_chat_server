package com.videochat.online.user.service;

import com.videochat.online.user.dto.UserInfoDTO;
import com.videochat.online.user.entity.User;
import com.videochat.online.user.exception.UserNotFoundException;
import com.videochat.online.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    @Override
    public UserInfoDTO getUserInfo(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(UserNotFoundException::new);
        return UserInfoDTO.from(user);
    }
}
