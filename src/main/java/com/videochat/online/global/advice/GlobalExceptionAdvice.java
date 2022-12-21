package com.videochat.online.global.advice;

import com.videochat.online.global.dto.APIResponseDTO;
import com.videochat.online.global.exception.GlobalExceptionInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionAdvice {

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    protected APIResponseDTO unknownException(Exception e){
        log.error(e.getStackTrace().toString());
        GlobalExceptionInfo exceptionInfo = GlobalExceptionInfo.UNKNOWN;
        return APIResponseDTO.fail(exceptionInfo.getCode(), exceptionInfo.getMessage());
    }

}
