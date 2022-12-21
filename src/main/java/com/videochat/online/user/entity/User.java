package com.videochat.online.user.entity;

import com.videochat.online.global.entity.BaseEntity;
import lombok.*;

import javax.persistence.*;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "users")
public class User extends BaseEntity {

    @Id
    @Column(name = "user_id", nullable = false, unique = true, length = 20)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    @Column(name = "email", nullable = false, unique = true)
    private String email;
    @Column(name = "password", nullable = false)
    private String password;
    @Column(name = "username", nullable = false, length = 20)
    private String username;
    @Column(name = "nickname", nullable = false, length = 20)
    private String nickname;
    @Column(name = "picture")
    private String picture;

    @ManyToMany
    @JoinTable(
            name = "user_role",
            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "role_id")})
    private Set<Role> userRole;

}
