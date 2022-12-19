package com.videochat.online.dto;

import com.videochat.online.user.dto.UserInfoDTO;
import com.videochat.online.user.entity.User;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class UserInfoDTOTest {

    @Test
    public void from_test(){
        // given
        User user = User.builder()
                .userId(1L)
                .email("test@test.com")
                .nickname("testNickname")
                .username("testUsername")
                .picture("testPicture")
                .build();

        // when
        UserInfoDTO userInfoDTO = UserInfoDTO.from(user);

        // then
        assertThat(userInfoDTO.getUserId()).isEqualTo(user.getUserId());
        assertThat(userInfoDTO.getEmail()).isEqualTo(user.getEmail());
        assertThat(userInfoDTO.getUsername()).isEqualTo(user.getUsername());
        assertThat(userInfoDTO.getPicture()).isEqualTo(user.getPicture());
    }

}
