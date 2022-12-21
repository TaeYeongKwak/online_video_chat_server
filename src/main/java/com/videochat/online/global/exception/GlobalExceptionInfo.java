package com.videochat.online.global.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum GlobalExceptionInfo {

    UNKNOWN(-9999, "알 수 없는 오류가 발생하였습니다.");

    private int code;
    private String message;

}
