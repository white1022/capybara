package com.example.demo.common;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.MethodArgumentNotValidException;
import java.util.Locale;
import com.example.demo.exception.BusinessException;
import com.example.demo.exception.UnauthorizedException;
import com.example.demo.exception.ForbiddenException;

@RestControllerAdvice
@RequiredArgsConstructor
public class GlobalExceptionHandler {
    private final MessageSource messageSource;

    /*
     * 捕获参数验证异常
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Result<?> handleValidException(MethodArgumentNotValidException e, Locale locale) {
        String key = e.getBindingResult().getFieldError().getDefaultMessage();
        String message = messageSource.getMessage(key, null, locale);
        return Result.fail(400, message);
    }

    /*
     * 捕获业务异常
     */
    @ExceptionHandler(BusinessException.class)
    public Result<?> handleBusiness(BusinessException e, Locale locale) {
        String message = messageSource.getMessage(e.getMessage(), e.getArgs(), locale);
        return Result.fail(e.getCode(), message);
    }

    /*
     * 捕获身份认证异常
     */
    @ExceptionHandler(UnauthorizedException.class)
    public Result<?> handleAuth(UnauthorizedException e, Locale locale) {
        String message = messageSource.getMessage(e.getMessage(), null, locale);
        return Result.fail(e.getCode(), message);
    }

    /*
     * 捕获权限不足异常
     */
    @ExceptionHandler(ForbiddenException.class)
    public Result<?> handleForbidden(ForbiddenException e, Locale locale) {
        String message = messageSource.getMessage(e.getMessage(), null, locale);
        return Result.fail(e.getCode(), message);
    }

    /*
     * 捕获未知异常
     */
    @ExceptionHandler(Exception.class)
    public Result<?> handleException(Exception e) {
        return Result.fail(500, "服务器错误：" + e.getMessage());
    }
}
