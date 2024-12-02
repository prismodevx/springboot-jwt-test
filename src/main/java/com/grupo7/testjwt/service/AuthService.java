package com.grupo7.testjwt.service;

import com.grupo7.testjwt.dto.ApiResponseDto;
import com.grupo7.testjwt.dto.SignInRequestDto;
import com.grupo7.testjwt.dto.SignUpRequestDto;
import com.grupo7.testjwt.exception.RoleNotFoundException;
import com.grupo7.testjwt.exception.UserAlreadyExistsException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface AuthService {
    ResponseEntity<ApiResponseDto<?>> signUpUser(SignUpRequestDto signUpRequestDto) throws UserAlreadyExistsException, RoleNotFoundException;
    ResponseEntity<ApiResponseDto<?>> signInUser(SignInRequestDto signInRequestDto);
}
