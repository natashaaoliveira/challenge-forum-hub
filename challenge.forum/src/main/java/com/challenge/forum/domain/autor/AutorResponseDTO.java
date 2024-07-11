package com.challenge.forum.domain.autor;

public record AutorResponseDTO(
        String name,
        String email
) {
    public AutorResponseDTO(Autor autor){
        this(autor.getName(), autor.getEmail());
    }
}
