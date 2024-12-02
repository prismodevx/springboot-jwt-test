package com.grupo7.testjwt.controller;

import com.grupo7.testjwt.dto.ApiResponseDto;
import com.grupo7.testjwt.dto.SignInRequestDto;
import com.grupo7.testjwt.dto.SignUpRequestDto;
import com.grupo7.testjwt.exception.RoleNotFoundException;
import com.grupo7.testjwt.exception.UserAlreadyExistsException;
import com.grupo7.testjwt.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<ApiResponseDto<?>> registerUser(@RequestBody @Valid SignUpRequestDto signUpRequestDto)
            throws UserAlreadyExistsException, RoleNotFoundException {
        return authService.signUpUser(signUpRequestDto);
    }

    @PostMapping("/signin")
    public ResponseEntity<ApiResponseDto<?>> signInUser(@RequestBody @Valid SignInRequestDto signInRequestDto){
        return authService.signInUser(signInRequestDto);
    }
}
