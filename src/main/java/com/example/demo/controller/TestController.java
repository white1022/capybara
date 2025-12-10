package com.example.demo.controller;

import jakarta.annotation.Resource;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
public class TestController {

    @Resource
    private MessageSource messageSource;

    @GetMapping("/hello")
    public String hello(Locale locale) {
        return messageSource.getMessage("welcome", null, locale);
    }

    @GetMapping("/login")
    public String login(Locale locale) {
        return messageSource.getMessage("login_success", null, locale);
    }
}
