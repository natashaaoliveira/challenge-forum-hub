package com.challenge.forum.domain.autor;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

public record AutorDTO(
        @NotEmpty
        String name,
        @NotEmpty @Email
        String email,
        @NotEmpty
        String password
) {

}