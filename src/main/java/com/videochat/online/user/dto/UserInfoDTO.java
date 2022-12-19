package com.videochat.online.user.dto;

import com.videochat.online.user.entity.User;
import lombok.*;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserInfoDTO {

    private Long userId;
    private String email;
    private String username;
    private String nickname;
    private String picture;

    public static UserInfoDTO from(User user){
        return new UserInfoDTO(
                user.getUserId(),
                user.getEmail(),
                user.getUsername(),
                user.getNickname(),
                user.getPicture()
        );
    }

}
