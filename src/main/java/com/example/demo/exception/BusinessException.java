package com.example.demo.exception;

import lombok.Getter;

@Getter
public class BusinessException extends RuntimeException {

    private final Integer code;
    private final Object[] args;

    public BusinessException(Integer code, String key, Object... args) {
        super(key);
        this.code = code;
        this.args = args;
    }
}
