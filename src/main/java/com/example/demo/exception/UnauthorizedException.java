package com.example.demo.exception;

import lombok.Getter;

@Getter
public class UnauthorizedException extends RuntimeException {

    private final Integer code;

    public UnauthorizedException(Integer code, String key) {
        super(key);
        this.code = code;
    }
}
