package com.be.grooming_mood.exception;

public class BadRequestException extends BusinessException{
    public BadRequestException(ErrorCode errorCode){
        super(errorCode);
    };
}
