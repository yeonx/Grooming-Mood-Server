package com.be.grooming_mood.exception;

public class NotFoundException extends BusinessException{
    public NotFoundException(ErrorCode errorCode){
        super(errorCode);
    };
}
