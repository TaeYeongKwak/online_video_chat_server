package com.videochat.online.user.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum UserExceptionInfo {

    USER_NOT_FOUND(-1000, "해당 사용자가 존재하지 않습니다.");

    private int code;
    private String message;
}
