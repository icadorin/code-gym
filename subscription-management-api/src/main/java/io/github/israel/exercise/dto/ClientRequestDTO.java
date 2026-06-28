package io.github.israel.exercise.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record ClientRequestDTO(

    @NotBlank(message = "Nome é obrigatório!")
    String name,

    @NotBlank(message = "Email é obrigatório!")
    @Email
    String email,

    @NotBlank(message = "Senha é obrigatória!")
    String password
) {}
