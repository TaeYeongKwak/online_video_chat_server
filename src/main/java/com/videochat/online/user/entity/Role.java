package com.videochat.online.user.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "role")
public class Role {

    @Id
    @Column(name = "role_id", nullable = false, unique = true, length = 20)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roleId;
    @Column(name = "authority", nullable = false)
    private String authority;

}
