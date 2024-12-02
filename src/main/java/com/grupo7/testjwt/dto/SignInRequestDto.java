package com.grupo7.testjwt.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SignInRequestDto {
    @NotBlank(message = "Email requerido")
    private String email;

    @NotBlank(message = "Contrasenia requerida")
    private String password;

}
