package com.videochat.online.user.service;

import com.videochat.online.auth.dto.SignupRequestDTO;
import com.videochat.online.user.dto.UserInfoDTO;
import com.videochat.online.user.entity.Role;
import com.videochat.online.user.entity.User;
import com.videochat.online.user.exception.UserNotFoundException;
import com.videochat.online.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserInfoDTO getUserInfo(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(UserNotFoundException::new);
        return UserInfoDTO.from(user);
    }

    @Transactional
    @Override
    public User createUser(SignupRequestDTO signupRequestDTO) {
        signupRequestDTO.encoding(passwordEncoder);
        return userRepository.save(signupRequestDTO.toEntity());
    }
}
