package com.videochat.online.repository;

import com.videochat.online.user.entity.User;
import com.videochat.online.user.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    User user;

    @BeforeEach
    public void setUp(){
        user = User.builder()
                .email("test@test.com")
                .password("testPassword")
                .nickname("testNickname")
                .username("testUsername")
                .picture("testPicture")
                .build();
    }

    @Test
    public void findById_test(){
        // given
        User saveUser = userRepository.save(user);
        Long userId = saveUser.getUserId();

        // when
        User findUser = userRepository.findById(userId).get();

        // then
        assertThat(findUser.getUserId()).isEqualTo(userId);
        assertThat(findUser.getEmail()).isEqualTo(saveUser.getEmail());
    }

    @Test
    public void save_test(){
        // when
        User saveUser = userRepository.save(user);

        // then
        assertThat(saveUser.getEmail()).isEqualTo(user.getEmail());
    }

}
