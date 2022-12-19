package com.videochat.online.user.advice;

import com.videochat.online.global.dto.APIResponseDTO;
import com.videochat.online.user.exception.UserExceptionInfo;
import com.videochat.online.user.exception.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class UserExceptionAdvice {

    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    protected APIResponseDTO userNotFoundException(){
        UserExceptionInfo e = UserExceptionInfo.USER_NOT_FOUND;
        return APIResponseDTO.fail(e.getCode(), e.getMessage());
    }

}
