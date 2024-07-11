package com.challenge.forum.domain.topic;

import com.challenge.forum.domain.autor.AutorDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public record TopicUpdateDTO(
        @NotNull
        Long id,
        String title,
        String message,
        AutorDTO autorDTO,
        String nameCourse
) {
}
