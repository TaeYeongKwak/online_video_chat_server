package com.videochat.online.auth.dto;

import com.videochat.online.user.entity.Role;
import com.videochat.online.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Collections;

@Getter
@Setter
@AllArgsConstructor
public class SignupRequestDTO {

    private String email;
    private String password;
    private String username;
    private String nickname;

    public void encoding(PasswordEncoder passwordEncoder){
        this.password = passwordEncoder.encode(password);
    }

    public User toEntity(){
        return User.builder()
                .email(email)
                .password(password)
                .username(username)
                .nickname(nickname)
                .userRole(Collections.singleton(new Role(1L, "ROLE_USER")))
                .build();
    }

}
