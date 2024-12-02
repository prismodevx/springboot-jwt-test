package com.grupo7.testjwt.controller;

import com.grupo7.testjwt.dto.ApiResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/test")
public class TestController {
    @GetMapping("/")
    public ResponseEntity<ApiResponseDto<?>> Test() {
        ApiResponseDto<?> response = ApiResponseDto.builder()
                .isSuccess(true)
                .message("spring security jwt")
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
