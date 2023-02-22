package com.smruti.jwtoauth.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smruti.jwtoauth.service.TokenService;

@RestController
public class HomeController {

    private final TokenService tokenService;

    public HomeController(TokenService tokenService) {
        this.tokenService = tokenService;
    }

    @GetMapping("/")
    public String home(Authentication authentication) {
        return "Welcome to home " + authentication.getName();
    }

    @GetMapping("/token")
    public String getToken(Authentication authentication) {
        return tokenService.generateToken(authentication);
    }
}
