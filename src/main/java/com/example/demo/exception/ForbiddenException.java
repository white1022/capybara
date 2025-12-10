package com.example.demo.exception;

import lombok.Getter;

@Getter
public class ForbiddenException extends RuntimeException {

    private final Integer code;

    public ForbiddenException(Integer code, String key) {
        super(key);
        this.code = code;
    }
}
