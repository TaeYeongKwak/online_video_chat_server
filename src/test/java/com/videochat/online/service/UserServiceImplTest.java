package com.videochat.online.service;

import com.videochat.online.user.dto.UserInfoDTO;
import com.videochat.online.user.entity.User;
import com.videochat.online.user.exception.UserNotFoundException;
import com.videochat.online.user.repository.UserRepository;
import com.videochat.online.user.service.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class UserServiceImplTest {

    @InjectMocks
    private UserServiceImpl userService;

    @Mock
    private UserRepository userRepository;

    User user;

    @BeforeEach
    public void setUp(){
        user = User.builder()
                .userId(1L)
                .email("test@test.com")
                .password("testPassword")
                .nickname("testNickname")
                .username("testUsername")
                .picture("testPicture")
                .build();
    }

    @Test
    public void getUserInfo_test(){
        // given
        given(userRepository.findById(any())).willReturn(Optional.ofNullable(user));
        Long userId = user.getUserId();

        // when
        UserInfoDTO findUserInfo = userService.getUserInfo(userId);

        // then
        assertThat(findUserInfo.getUserId()).isEqualTo(userId);
        assertThat(findUserInfo.getEmail()).isEqualTo(user.getEmail());
    }

    @Test
    public void getUserInfo_error_test(){
        // given
        given(userRepository.findById(any())).willReturn(Optional.empty());
        Long userId = user.getUserId();

        // then
        assertThrows(UserNotFoundException.class, () -> {
            userService.getUserInfo(userId);
        });
    }
}
